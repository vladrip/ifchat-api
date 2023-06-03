package com.vladrip.ifchat.service;

import com.vladrip.ifchat.dto.ChatGroupDto;
import com.vladrip.ifchat.dto.ChatListElDto;
import com.vladrip.ifchat.dto.ChatMemberShortDto;
import com.vladrip.ifchat.dto.ChatPrivateDto;
import com.vladrip.ifchat.entity.Chat;
import com.vladrip.ifchat.entity.ChatMember;
import com.vladrip.ifchat.exception.EntityNotFoundException;
import com.vladrip.ifchat.mapping.Mapper;
import com.vladrip.ifchat.repository.ChatMemberRepository;
import com.vladrip.ifchat.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChatService {
    private final ChatRepository chatRepository;
    private final ChatMemberRepository chatMemberRepository;
    private final Mapper mapper;

    public Page<ChatListElDto> getChatList(String personUid, Pageable pageable) {
        Page<ChatListElDto> chatListDtoPage = chatRepository.collectChatListByPersonId(personUid, pageable);
        return chatListDtoPage.map(chatListDto -> {
            if (chatListDto.getChatType() == Chat.ChatType.PRIVATE) {
                ChatMember otherMember = chatMemberRepository.getOtherPrivateChatMember(chatListDto.getChatId(), personUid)
                        .orElseThrow(() -> EntityNotFoundException.of("Chat", chatListDto.getChatId()));
                return ChatListElDto.of(chatListDto, otherMember.getPerson().getFullName());
            } else return chatListDto;
        });
    }

    public ChatPrivateDto getPrivateChat(Long id, String personUid) {
        Chat chat = chatRepository.findById(id)
                .orElseThrow(() -> EntityNotFoundException.of("Chat", id));
        ChatMember otherMember = chatMemberRepository.getOtherPrivateChatMember(id, personUid)
                .orElseThrow(() -> EntityNotFoundException.of("Other member of chat %d with member %s", id, personUid));
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
}
