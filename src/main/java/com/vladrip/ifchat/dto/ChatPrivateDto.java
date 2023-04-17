package com.vladrip.ifchat.dto;

import com.vladrip.ifchat.entity.Chat.ChatType;
import lombok.Value;

@Value
public class ChatPrivateDto {
    Long id;
    ChatType type;
    PersonDto otherPerson;
}
