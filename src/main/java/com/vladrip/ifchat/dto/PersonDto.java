package com.vladrip.ifchat.dto;

import com.vladrip.ifchat.entity.Person;
import lombok.Data;

@Data
public class PersonDto {
    private Long id;
    private String phoneNumber;
    private String tag;
    private String firstName;
    private String lastName;
    private String bio;
    private Person.PrivacyScope phoneVisible = Person.PrivacyScope.CONTACTS;
}
