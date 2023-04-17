package com.vladrip.ifchat.controller;

import com.vladrip.ifchat.dto.*;
import com.vladrip.ifchat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/chats")
public class ChatController {
    private final ChatService chatService;

    @GetMapping
    public Page<ChatListElDto> getList(Long personId, @PageableDefault @ParameterObject Pageable pageable) {
        return chatService.getChatList(personId, pageable);
    }

    @GetMapping("/p{id}")
    public ChatPrivateDto getPrivate(@PathVariable Long id, Long personId) {
        return chatService.getPrivateChat(id, personId);
    }

    @GetMapping("/g{id}")
    public ChatGroupDto getGroup(@PathVariable Long id) {
        return chatService.getGroupChat(id);
    }

    @GetMapping("/{id}/members")
    public Page<ChatMemberShortDto> getMembers(@PathVariable Long id,
                                               @PageableDefault @ParameterObject Pageable pageable) {
        return chatService.getMembers(id, pageable);
    }

    @GetMapping("/{id}/messages")
    public List<MessageDto> getMessages(@PathVariable Long id, Long beforeId, Long afterId, int limit) {
        return chatService.getAllMessages(id, beforeId, afterId, limit);
    }
}