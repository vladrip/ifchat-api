package com.vladrip.ifchat.service;

import com.vladrip.ifchat.dto.ChatListDto;
import com.vladrip.ifchat.entity.Chat;
import com.vladrip.ifchat.entity.ChatMember;
import com.vladrip.ifchat.entity.Message;
import com.vladrip.ifchat.mapping.Mapper;
import com.vladrip.ifchat.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChatService {
    private final ChatRepository chatRepository;
    private final Mapper mapper;

    public Page<ChatListDto> getAllByPersonId(Long personId, Pageable pageable) {
        Page<Object[]> chatListData = chatRepository.findAllByPersonId(personId, pageable);
        return chatListData.map(chatListDataEntry -> mapper.toChatListDto(
                (Chat) chatListDataEntry[0],
                (ChatMember) chatListDataEntry[1],
                (Message) chatListDataEntry[2]));
    }
}
