package com.vladrip.ifchat.controller;

import com.vladrip.ifchat.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {
    private final MessageService messageService;

}
