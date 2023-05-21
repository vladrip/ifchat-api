package com.vladrip.ifchat.repository;

import com.vladrip.ifchat.dto.ChatListElDto;
import com.vladrip.ifchat.entity.Chat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    @Query("""
                SELECT new com.vladrip.ifchat.dto.ChatListElDto(c.id, c.name, c.type, m.id, m.content, m.sentAt, cm.chatMuted)
                FROM Chat c
                INNER JOIN ChatMember cm ON c.id = cm.chat.id
                LEFT JOIN Message m ON c.id = m.chat.id
                WHERE cm.person.uid = :personUid
                ORDER BY m.sentAt DESC
            """)
    Page<ChatListElDto> collectChatListByPersonId(String personUid, Pageable pageable);
}