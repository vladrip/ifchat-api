package com.vladrip.ifchat.dto;

import com.vladrip.ifchat.entity.Chat;
import lombok.Value;

@Value
public class ChatDto {
    Long id;
    String name;
    String description;
    Chat.ChatType type;
    boolean publicGroup;
}