package com.vladrip.ifchat.service;

import com.vladrip.ifchat.dto.*;
import com.vladrip.ifchat.entity.Chat;
import com.vladrip.ifchat.entity.ChatMember;
import com.vladrip.ifchat.entity.Message;
import com.vladrip.ifchat.exception.EntityNotFoundException;
import com.vladrip.ifchat.mapping.Mapper;
import com.vladrip.ifchat.repository.ChatMemberRepository;
import com.vladrip.ifchat.repository.ChatRepository;
import com.vladrip.ifchat.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ChatService {
    private final ChatRepository chatRepository;
    private final MessageRepository messageRepository;
    private final ChatMemberRepository chatMemberRepository;
    private final Mapper mapper;

    public Page<ChatListElDto> getChatList(Long personId, Pageable pageable) {
        Page<ChatListElDto> chatListDtoPage = chatRepository.collectChatListByPersonId(personId, pageable);
        return chatListDtoPage.map(chatListDto -> {
            if (chatListDto.getChatType() == Chat.ChatType.PRIVATE) {
                ChatMember otherMember = chatMemberRepository.getOtherPrivateChatMember(chatListDto.getChatId(), personId)
                        .orElseThrow(() -> EntityNotFoundException.of("Chat", chatListDto.getChatId()));
                return ChatListElDto.of(chatListDto, otherMember.getPerson().getFullName());
            } else return chatListDto;
        });
    }

    public ChatPrivateDto getPrivateChat(Long id, Long personId) {
        Chat chat = chatRepository.findById(id)
                .orElseThrow(() -> EntityNotFoundException.of("Chat", id));
        ChatMember otherMember = chatMemberRepository.getOtherPrivateChatMember(id, personId)
                .orElseThrow(() -> EntityNotFoundException.of("Other member of chat %d with member %d", id, personId));
        return mapper.toChatPrivateDto(chat, otherMember.getPerson());
    }

    public ChatGroupDto getGroupChat(Long id) {
        return mapper.toChatGroupDto(chatRepository.findById(id)
                        .orElseThrow(() -> EntityNotFoundException.of("Chat", id)),
                chatMemberRepository.countByChatId(id));
    }

    public Page<ChatMemberShortDto> getMembers(Long id, Pageable pageable) {
        return chatMemberRepository.getChatMembersByChatId(id, pageable).map(mapper::toChatMemberShortDto);
    }

    public List<MessageDto> getAllMessages(Long chatId, Long beforeId, Long afterId, int limit) {
        Pageable queryLimit = PageRequest.of(0, limit);
        boolean isRefresh = beforeId.equals(afterId);
        List<Message> messages = new ArrayList<>();
        if (beforeId != 0 || isRefresh)
            messages.addAll(messageRepository.getByChatIdAndBeforeId(chatId, beforeId, queryLimit));
        if (afterId != 0 || isRefresh)
            messages.addAll(messageRepository.getByChatIdAndAfterId(chatId, afterId, queryLimit));

        return messages.stream()
                .map(mapper::toMessageDto)
                .collect(Collectors.toList());
    }
}
