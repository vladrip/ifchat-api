package com.vladrip.ifchat.entity;

import jakarta.persistence.*;
import lombok.*;

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

    private String phoneNumber;

    private String password;

    private String tag;

    private String firstName;

    private String lastName;

    private String bio;

    private String profilePicture;

    private Boolean phoneVisible;

    @ToString.Exclude
    @OneToMany(mappedBy = "person")
    private List<GroupMember> groupMembers;
}