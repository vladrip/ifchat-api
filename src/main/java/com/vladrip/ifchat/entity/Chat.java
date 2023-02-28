package com.vladrip.ifchat.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Chat {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ChatType type;

    private Boolean publicGroup;

    private String inviteLink;

    @ToString.Exclude
    @OneToMany(mappedBy = "chat")
    private List<Message> messages;

    public enum ChatType {
        PRIVATE,
        GROUP
    }
}
