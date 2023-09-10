package com.vladrip.ifchat.dto;

import com.vladrip.ifchat.entity.Chat.ChatType;
import lombok.Value;

@Value
public class ChatDto {
    Long id;
    ChatType type;
    PersonDto otherPerson;
    String name;
    String description;
    int memberCount;
}
