package com.example.kwwqxmokvrqzdaaspscp.util.PersonException;

public class PersonNotFoundException extends RuntimeException{
    public PersonNotFoundException(int id ){
        super("Person with id: " + id + "not found!");
    }
}
