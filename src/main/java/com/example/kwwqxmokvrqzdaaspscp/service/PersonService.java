package com.example.kwwqxmokvrqzdaaspscp.service;

import com.example.kwwqxmokvrqzdaaspscp.entity.Person;
import com.example.kwwqxmokvrqzdaaspscp.repository.PersonRepository;
import com.example.kwwqxmokvrqzdaaspscp.util.PersonNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAll(){
        return personRepository.findAll();
    }

    public Person findOne(int id){
        Optional<Person> foundPerson = personRepository.findById(id);
        return foundPerson.orElseThrow();
    }
    @Transactional
    public Person create(Person person){
        enrichPerson(person);
        return personRepository.save(person);
    }
    private void deletePerson(int id){
        personRepository.deleteById(id);
    }
    public Person updatePeople(int id, Person updatedPerson) {
        Optional<Person> existingPerson = personRepository.findById(id);
        if (existingPerson.isPresent()) {
            Person personToUpdate = existingPerson.get();
            personToUpdate.setName(updatedPerson.getName());
            personToUpdate.setBirthYear(updatedPerson.getBirthYear());
            personToUpdate.setFirstPhoneNum(updatedPerson.getFirstPhoneNum());
            personToUpdate.setSecondPhoneNum(updatedPerson.getSecondPhoneNum());
            return personRepository.save(personToUpdate);
        } else {
            return null;
        }
    }
    private void  enrichPerson(Person person){
        person.setCreatedAt(LocalDateTime.now());
    }
}
