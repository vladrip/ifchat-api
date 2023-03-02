package com.vladrip.ifchat.repository;

import com.vladrip.ifchat.entity.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> {
    List<GroupMember> findAllByPersonId(Long id);
}