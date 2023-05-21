package com.vladrip.ifchat.controller;

import com.vladrip.ifchat.dto.*;
import com.vladrip.ifchat.service.ChatService;
import com.vladrip.ifchat.service.FirebaseService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/chats")
public class ChatController {
    private final ChatService chatService;
    private final FirebaseService firebaseService;

    @GetMapping
    public Page<ChatListElDto> getChatList(@RequestHeader(name = "Authorization") String authToken,
                                           @PageableDefault @ParameterObject Pageable pageable) {
        return chatService.getChatList(firebaseService.uidFromToken(authToken), pageable);
    }

    @GetMapping("/p{id}")
    public ChatPrivateDto getPrivate(@PathVariable Long id, @RequestHeader(name = "Authorization") String authToken) {
        return chatService.getPrivateChat(id, firebaseService.uidFromToken(authToken));
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