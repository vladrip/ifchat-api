package com.vladrip.ifchat.controller;

import com.vladrip.ifchat.dto.ChatListDto;
import com.vladrip.ifchat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/chat")
public class ChatController {
    private final ChatService chatService;

    @GetMapping
    public Page<ChatListDto> getAll(Long personId, @PageableDefault @ParameterObject Pageable pageable) {
        return chatService.getAllByPersonId(personId, pageable);
    }
}