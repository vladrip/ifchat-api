package com.vladrip.ifchat.mapping;

import com.vladrip.ifchat.dto.*;
import com.vladrip.ifchat.entity.Chat;
import com.vladrip.ifchat.entity.ChatMember;
import com.vladrip.ifchat.entity.Message;
import com.vladrip.ifchat.entity.Person;
import org.mapstruct.Mapping;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {
    PersonDto toPersonDto(Person person);

    PersonShortDto toPersonShortDto(Person person);

    @Mapping(target = "chatId", source = "message.chat.id")
    MessageDto toMessageDto(Message message);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "chat", ignore = true)
    @Mapping(target = "sender", ignore = true)
    Message toMessage(MessageDto messageDto);

    @Mapping(target = "id", source = "chat.id")
    @Mapping(target = "otherPerson", source = "person")
    ChatDto toChatDto(Chat chat, Person person);

    ChatDto toChatDto(Chat chat, int memberCount);

    @Mapping(target = "chatId", source = "chat.id")
    @Mapping(target = "firstName", source = "person.firstName")
    @Mapping(target = "lastName", source = "person.lastName")
    @Mapping(target = "onlineAt", source = "person.onlineAt")
    ChatMemberShortDto toChatMemberShortDto(ChatMember chatMember);
}
