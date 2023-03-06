package com.vladrip.ifchat.repository;

import com.vladrip.ifchat.entity.Chat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    @Query("""
        select c, cm, m
        from Chat c
                 inner join ChatMember cm on c.id = cm.chat.id
                 inner join Message m on c.id = m.chat.id
        where cm.person.id = 1
          and m.sentAt in (select max(m2.sentAt)
                            from ChatMember cm2
                                     inner join Message m2 on cm2.chat.id = m2.chat.id
                            where cm2.person.id = :personId
                            group by m2.chat.id)
    """)
    Page<Object[]> findAllByPersonId(Long personId, Pageable pageable);
}