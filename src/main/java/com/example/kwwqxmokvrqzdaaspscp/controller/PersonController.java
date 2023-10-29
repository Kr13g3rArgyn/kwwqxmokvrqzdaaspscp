package com.example.kwwqxmokvrqzdaaspscp.controller;
import com.example.kwwqxmokvrqzdaaspscp.service.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final ModelMapper mapper;
    private final PersonService personService;

    public PersonController(PersonService personService, ModelMapper mapper) {
        this.personService = personService;
        this.mapper = mapper;
    }

    @GetMapping
    private String getAll(){
        return "";
    }
}
