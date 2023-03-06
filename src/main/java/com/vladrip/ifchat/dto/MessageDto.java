package com.vladrip.ifchat.dto;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class MessageDto {
    Long id;
    String fromNumber;
    String content;
    LocalDateTime sentAt;
    Long chatId;
}
