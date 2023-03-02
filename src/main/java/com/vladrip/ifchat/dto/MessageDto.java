package com.vladrip.ifchat.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageDto {
    private String fromNumber;
    private String content;
    private LocalDateTime sentAt;
    private Long chatId;
}
