package com.vladrip.ifchat.mapping;

import com.vladrip.ifchat.dto.ChatDto;
import com.vladrip.ifchat.dto.ChatListDto;
import com.vladrip.ifchat.dto.ChatMemberDto;
import com.vladrip.ifchat.dto.MessageDto;
import com.vladrip.ifchat.entity.Chat;
import com.vladrip.ifchat.entity.ChatMember;
import com.vladrip.ifchat.entity.Message;
import org.mapstruct.Mapping;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {
    @Mapping(target = "chatId", source = "chat.id")
    MessageDto toMessageDto(Message message);
    @Mapping(target = "chat", ignore = true)
    Message toMessage(MessageDto messageDto);

    ChatDto toChatDto(Chat chat);
    @Mapping(target = "messages", ignore = true)
    @Mapping(target = "chatMembers", ignore = true)
    Chat toChat(ChatDto chatDto);

    @Mapping(target = "chatId", source = "chat.id")
    @Mapping(target = "personId", source = "person.id")
    ChatMemberDto toChatMemberDto(ChatMember chatMember);
    @Mapping(target = "chat", ignore = true)
    @Mapping(target = "person", ignore = true)
    ChatMember toChatMember(ChatMemberDto chatMemberDto);

    //why without this line its compile-time error? - Several possible source properties for target property "chat"
    @Mapping(target = "chat", source = "chat")
    ChatListDto toChatListDto(Chat chat, ChatMember chatMember, Message lastMessage);
}
