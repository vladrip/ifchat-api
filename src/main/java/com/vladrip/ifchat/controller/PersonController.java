package com.vladrip.ifchat.controller;

import com.vladrip.ifchat.dto.PersonDto;
import com.vladrip.ifchat.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {
    private final PersonService personService;

    @GetMapping("/{uid}")
    public PersonDto get(@PathVariable String uid) {
        return personService.get(uid);
    }
}
