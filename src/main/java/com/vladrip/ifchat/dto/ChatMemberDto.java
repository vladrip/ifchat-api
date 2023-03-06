package com.vladrip.ifchat.dto;

import lombok.Value;

@Value
public class ChatMemberDto {
    Long id;
    Long chatId;
    Long personId;
    boolean chatMuted;
}
