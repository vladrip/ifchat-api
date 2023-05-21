package com.vladrip.ifchat.dto;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class ChatMemberShortDto {
    Long id;
    String personUid;
    String firstName;
    String lastName;
    LocalDateTime onlineAt;
}
