package com.vladrip.ifchat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    @Length(max = 128)
    @Id
    private String uid;

    @Length(max = 32)
    @Column(unique = true)
    private String tag;

    @Length(min = 1, max = 64)
    @NotNull
    private String firstName;

    @Length(max = 64)
    private String lastName;

    private LocalDateTime onlineAt = LocalDateTime.now();

    @ToString.Exclude
    @OneToMany(mappedBy = "person")
    private List<ChatMember> chatMembers;

    @ToString.Exclude
    @OneToMany(mappedBy = "sender")
    private List<Message> messages;

    @ToString.Exclude
    @OneToMany(mappedBy = "person")
    private List<Device> devices;

    public String getFullName() {
        return firstName.concat(" ").concat(lastName);
    }
}