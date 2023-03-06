package com.vladrip.ifchat.service;

import com.vladrip.ifchat.dto.MessageDto;
import com.vladrip.ifchat.entity.Message;
import com.vladrip.ifchat.exception.EntityNotFoundException;
import com.vladrip.ifchat.mapping.Mapper;
import com.vladrip.ifchat.repository.ChatRepository;
import com.vladrip.ifchat.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final ChatRepository chatRepository;
    private final Mapper mapper;

    public void create(MessageDto messageDto, Long chatId) {
        Message message = mapper.toMessage(messageDto);
        message.setChat(chatRepository.findById(chatId).orElseThrow(()->EntityNotFoundException.of("Chat", chatId)));
        messageRepository.save(message);
        //@TODO: notify chat members using Firebase: message.chat.chatMembers.filter(!message.fromNumber)
    }
}