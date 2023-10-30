package com.example.kwwqxmokvrqzdaaspscp.component;

import com.example.kwwqxmokvrqzdaaspscp.dto.PersonDTO;
import com.example.kwwqxmokvrqzdaaspscp.entity.Person;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {
    private final ModelMapper mapper;

    public PersonMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }
    public Person convertToPerson(PersonDTO personDTO) {
        return mapper.map(personDTO, Person.class);
    }

    public PersonDTO convertToPersonDTO(Person person) {
        return mapper.map(person, PersonDTO.class);
    }
}
