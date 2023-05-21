package com.vladrip.ifchat.dto;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class PersonDto {
    String uid;
    String phoneNumber;
    String tag;
    String firstName;
    String lastName;
    String bio;
    LocalDateTime onlineAt;
}
