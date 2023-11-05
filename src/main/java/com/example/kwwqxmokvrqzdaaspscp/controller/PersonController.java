package com.example.kwwqxmokvrqzdaaspscp.controller;
import com.example.kwwqxmokvrqzdaaspscp.component.PersonMapper;
import com.example.kwwqxmokvrqzdaaspscp.dto.PersonDTO;
import com.example.kwwqxmokvrqzdaaspscp.entity.Person;
import com.example.kwwqxmokvrqzdaaspscp.service.PersonService;
import com.example.kwwqxmokvrqzdaaspscp.util.PersonException.PersonNotCreatedException;
import jakarta.validation.Valid;
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

    private final PersonService personService;

    private final PersonMapper mapper;
        public PersonController(PersonService personService, PersonMapper mapper) {
        this.personService = personService;
        this.mapper = mapper;
    }

    @GetMapping
    private List<PersonDTO> getAll(){
        return personService.getAll().stream().map(mapper::convertToPersonDTO).collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    private Person getOneDude(int id){
        return personService.findOne(id);
    }

    @DeleteMapping("/delete/{id}")
    private void deletePerson(@PathVariable("id") int id){
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
        personService.create(mapper.convertToPerson(personDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    private PersonDTO updatePerson(@PathVariable int id, @RequestBody PersonDTO personDTO){
               return personService.updatePeople(id, personDTO);
    }



//    DELAEM FILTER YEEEE




    @GetMapping("/filter/{limit}/{offset}")
    private List<PersonDTO> getPeopleThroughFilter(@PathVariable int limit, int offset){
            return personService.getPeopleThroughLimitAndOffset(limit,offset).stream().map(mapper::convertToPersonDTO).collect(Collectors.toList());
        }

}
