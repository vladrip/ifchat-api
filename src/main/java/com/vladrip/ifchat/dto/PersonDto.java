package com.vladrip.ifchat.dto;

import com.vladrip.ifchat.entity.Person;
import lombok.Value;

@Value
public class PersonDto {
    Long id;
    String phoneNumber;
    String tag;
    String firstName;
    String lastName;
    String bio;
    Person.PrivacyScope phoneVisible = Person.PrivacyScope.CONTACTS;
}
