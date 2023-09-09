package com.vladrip.ifchat.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "chat_member")
@Entity
public class ChatMember {
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotNull
    private boolean chatMuted = false;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "person_uid", columnDefinition = "varchar(128)")
    private Person person;
}