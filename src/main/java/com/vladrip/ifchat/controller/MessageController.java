package com.vladrip.ifchat.controller;

import com.vladrip.ifchat.dto.MessageDto;
import com.vladrip.ifchat.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {
    private final MessageService messageService;

    @PostMapping
    public void create(@RequestBody MessageDto messageDto) {
        messageService.create(messageDto);
    }
}
