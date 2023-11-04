package com.example.kwwqxmokvrqzdaaspscp.controller;

import com.example.kwwqxmokvrqzdaaspscp.entity.Dude;
import com.example.kwwqxmokvrqzdaaspscp.repository.DudeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.swing.*;
import java.util.List;

@Controller
public class DudeController {
    private final DudeRepository dudeRepository;
    public DudeController(DudeRepository dudeRepository){
        this.dudeRepository = dudeRepository;
    }
    @GetMapping
    private List<Dude> getAll(){
        return dudeRepository.findAll();
    }


}
