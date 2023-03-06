package com.vladrip.ifchat.dto;

import lombok.Value;

@Value
public class ChatListDto {
    ChatDto chat;
    ChatMemberDto chatMember;
    MessageDto lastMessage;
}
