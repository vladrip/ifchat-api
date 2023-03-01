package com.vladrip.ifchat.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

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
    private String tag;

    @Length(max = 64)
    private String firstName;

    @Length(max = 64)
    private String lastName;

    @Length(max = 100)
    private String bio;

    @Enumerated(EnumType.STRING)
    private PrivacyScope phoneVisible = PrivacyScope.CONTACTS;

    @ToString.Exclude
    @OneToMany(mappedBy = "person")
    private List<GroupMember> groupMembers;

    public enum PrivacyScope {
        EVERYBODY,
        NOBODY,
        CONTACTS
    }
}