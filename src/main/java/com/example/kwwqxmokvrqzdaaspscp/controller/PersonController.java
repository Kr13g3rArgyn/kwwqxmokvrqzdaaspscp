package com.example.kwwqxmokvrqzdaaspscp.controller;
import com.example.kwwqxmokvrqzdaaspscp.dto.PersonDTO;
import com.example.kwwqxmokvrqzdaaspscp.entity.Person;
import com.example.kwwqxmokvrqzdaaspscp.service.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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
    private List<PersonDTO> getAll(){
        return personService.getAll().stream().map(this::convertToPeopleDTO).collect(Collectors.toList());
    }



    private Person convertToPerson(PersonDTO peopleDTO) {
        return mapper.map(peopleDTO, Person.class);
    }
    private PersonDTO convertToPeopleDTO(Person people){
        return mapper.map(people, PersonDTO.class);
    }
}
