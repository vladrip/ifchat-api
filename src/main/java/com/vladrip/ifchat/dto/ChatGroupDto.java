package com.vladrip.ifchat.dto;

import com.vladrip.ifchat.entity.Chat.ChatType;
import lombok.Value;

@Value
public class ChatGroupDto {
    Long id;
    ChatType type = ChatType.GROUP;
    String name;
    String description;
    int memberCount;
}
