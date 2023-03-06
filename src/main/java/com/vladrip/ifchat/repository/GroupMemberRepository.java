package com.vladrip.ifchat.repository;

import com.vladrip.ifchat.entity.ChatMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupMemberRepository extends JpaRepository<ChatMember, Long> {
    List<ChatMember> findAllByPersonId(Long id);
}