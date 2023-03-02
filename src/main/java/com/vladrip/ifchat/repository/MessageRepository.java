package com.vladrip.ifchat.repository;

import com.vladrip.ifchat.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(value = """
        select m from
                     (select m, row_number() over (partition by m.chat_id order by sent_at desc) as msg_num
                      from message m
                      inner join chat c on c.id = m.chat_id
                      inner join group_member gm on gm.chat_id = c.id
                      where gm.person_id = :id) newest_msg
        where msg_num <= :updateLimit
    """, nativeQuery = true)
    List<Message> findLastPerChatByPersonId(Long id, int updateLimit);

    List<Message> findByChatId(Long id);
}