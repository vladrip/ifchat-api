package com.vladrip.ifchat.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Person {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String phoneNumber;

    @NotNull
    private String password;

    @Length(max = 32)
    @Column(unique = true)
    private String tag;

    @Length(min = 1, max = 64)
    @NotNull
    private String firstName;

    @Length(max = 64)
    private String lastName;

    @Length(max = 100)
    private String bio;

    private LocalDateTime onlineAt = LocalDateTime.now();

    @ToString.Exclude
    @OneToMany(mappedBy = "person")
    private List<ChatMember> chatMembers;

    @ToString.Exclude
    @OneToMany(mappedBy = "sender")
    private List<Message> messages;

    public String getFullName() {
        return firstName.concat(" ").concat(lastName);
    }
}