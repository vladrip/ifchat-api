package com.vladrip.ifchat.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Check;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Chat {
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Length(max = 150)
    private String name;

    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ChatType type;

    @NotNull
    private boolean publicGroup = true;

    @ToString.Exclude
    @OneToMany(mappedBy = "chat")
    private List<Message> messages;

    public enum ChatType {
        PRIVATE,
        GROUP
    }
}
