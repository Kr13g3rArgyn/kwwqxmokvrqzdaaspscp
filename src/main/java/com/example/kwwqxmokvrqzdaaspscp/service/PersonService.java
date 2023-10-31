package com.example.kwwqxmokvrqzdaaspscp.service;

import com.example.kwwqxmokvrqzdaaspscp.component.PersonMapper;
import com.example.kwwqxmokvrqzdaaspscp.dto.PersonDTO;
import com.example.kwwqxmokvrqzdaaspscp.entity.Person;
import com.example.kwwqxmokvrqzdaaspscp.repository.PersonRepository;
import com.example.kwwqxmokvrqzdaaspscp.util.PersonNotCreatedException;
import com.example.kwwqxmokvrqzdaaspscp.util.PersonNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;
    @Autowired
    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public List<Person> getAll(){
        return personRepository.findAll();
    }

    public Person findOne(int id){
        String msg = "";
        Optional<Person> foundPerson = personRepository.findById(id);
        return foundPerson.orElseThrow(null);
    }
    @Transactional
    public Person create(Person person){
        enrichPerson(person);
        return personRepository.save(person);
    }
    public void deletePerson(int id){
        personRepository.deleteById(id);
    }
    public PersonDTO updatePeople(int id, PersonDTO updatedPerson) {
        Optional<Person> existingPerson = personRepository.findById(id);
        if (existingPerson.isPresent()) {
            Person personToUpdate = existingPerson.get();
            personToUpdate.setName(updatedPerson.getName());
            personToUpdate.setFirstPhoneNum(updatedPerson.getFirstPhoneNum());
            personToUpdate.setSecondPhoneNum(updatedPerson.getSecondPhoneNum());
            personRepository.save(personToUpdate);
            return personMapper.convertToPersonDTO(personToUpdate);
        } else {
            throw new PersonNotCreatedException("Person with id " + id + " not found");
        }
    }

    //Filter
    public List<Person> getPeopleThroughLimitAndOffset(int limit, int offset){
        return personRepository.findAllWithLimitAndOffset(limit,offset).stream().collect(Collectors.toList());
    }


    private void  enrichPerson(Person person){ //Setting local date time when its created
        person.setCreatedAt(LocalDateTime.now());
    }
}
