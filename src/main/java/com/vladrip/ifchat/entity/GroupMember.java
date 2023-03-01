package com.vladrip.ifchat.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class GroupMember {
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;
}