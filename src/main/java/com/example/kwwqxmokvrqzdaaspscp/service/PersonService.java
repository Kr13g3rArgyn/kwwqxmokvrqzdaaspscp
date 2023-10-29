package com.example.kwwqxmokvrqzdaaspscp.service;

import com.example.kwwqxmokvrqzdaaspscp.entity.Person;
import com.example.kwwqxmokvrqzdaaspscp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    private List<Person> findAll(){
        return personRepository.findAll();
    }

}
