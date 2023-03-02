package com.vladrip.ifchat.dto;

import com.vladrip.ifchat.entity.Chat;
import lombok.Data;

@Data
public class ChatDto {
    private String name;
    private String description;
    private Chat.ChatType type;
    private boolean publicGroup;
}