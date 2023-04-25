package com.vladrip.ifchat.service;

import com.vladrip.ifchat.dto.MessageDto;
import com.vladrip.ifchat.entity.Message;
import com.vladrip.ifchat.exception.EntityNotFoundException;
import com.vladrip.ifchat.mapping.Mapper;
import com.vladrip.ifchat.repository.ChatRepository;
import com.vladrip.ifchat.repository.MessageRepository;
import com.vladrip.ifchat.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final ChatRepository chatRepository;
    private final PersonRepository personRepository;
    private final Mapper mapper;

    public Message create(MessageDto messageDto) {
        Message message = mapper.toMessage(messageDto);
        Long chatId = messageDto.getChatId(), senderId = messageDto.getSender().getId();
        message.setChat(chatRepository.findById(chatId).orElseThrow(()->EntityNotFoundException.of("Chat", chatId)));
        message.setSender(personRepository.findById(senderId).orElseThrow(()->EntityNotFoundException.of("Person", senderId)));
        return messageRepository.save(message);
        //notify chat members: message.chat.chatMembers.filter(!message.fromNumber)
    }

    public void delete(Long id) {
        messageRepository.deleteById(id);
    }
}