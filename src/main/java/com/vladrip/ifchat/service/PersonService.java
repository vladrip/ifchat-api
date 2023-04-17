package com.vladrip.ifchat.service;

import com.vladrip.ifchat.mapping.Mapper;
import com.vladrip.ifchat.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final Mapper mapper;


}
