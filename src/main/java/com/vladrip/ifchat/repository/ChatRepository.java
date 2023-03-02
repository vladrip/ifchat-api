package com.vladrip.ifchat.repository;

import com.vladrip.ifchat.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    
}