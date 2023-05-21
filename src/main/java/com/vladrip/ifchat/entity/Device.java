package com.vladrip.ifchat.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Device {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "person_uid")
    private Person person;

    @Column(unique = true, nullable = false)
    private String deviceToken;

    private LocalDateTime tokenTimestamp = LocalDateTime.now();
}
