package com.example.kwwqxmokvrqzdaaspscp.controller;
import com.example.kwwqxmokvrqzdaaspscp.dto.PersonDTO;
import com.example.kwwqxmokvrqzdaaspscp.entity.Person;
import com.example.kwwqxmokvrqzdaaspscp.service.PersonService;
import com.example.kwwqxmokvrqzdaaspscp.util.PersonNotCreatedException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    private Person getOneDude(int id){
        return personService.findOne(id);
    }

    @DeleteMapping("/delete/{id}")
    private void deletePerson(int id){
        personService.deletePerson(id);
    }

    @PostMapping("/create")
    private ResponseEntity<HttpStatus> createPerson(@RequestBody @Valid PersonDTO personDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            StringBuilder msg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError fieldError : errors){
                msg.append(fieldError.getField())
                        .append(" - ").append(fieldError.getDefaultMessage())
                        .append(";");
            }
            throw new PersonNotCreatedException(msg.toString());
        }
        personService.create(convertToPerson(personDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    private Person updatePerson(@PathVariable int id, @RequestBody Person person){
               return personService.updatePeople(id, person);
    }


    private Person convertToPerson(PersonDTO peopleDTO) {
        return mapper.map(peopleDTO, Person.class);
    }
    private PersonDTO convertToPeopleDTO(Person people){
        return mapper.map(people, PersonDTO.class);
    }
}
