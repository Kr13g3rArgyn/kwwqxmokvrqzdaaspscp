package com.example.kwwqxmokvrqzdaaspscp.component;

import com.example.kwwqxmokvrqzdaaspscp.dto.DudeDTO;
import com.example.kwwqxmokvrqzdaaspscp.dto.PersonDTO;
import com.example.kwwqxmokvrqzdaaspscp.entity.Dude;
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
    public Dude convertToDude(DudeDTO dudeDTO){
        return mapper.map(dudeDTO, Dude.class);
    }
    public DudeDTO convertToDudeDTO(Dude dude){
        return mapper.map(dude, DudeDTO.class);
    }
}
