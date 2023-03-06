package com.vladrip.ifchat.repository;

import com.vladrip.ifchat.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
    Page<Message> findByChatId(Long id, Pageable pageable);
}