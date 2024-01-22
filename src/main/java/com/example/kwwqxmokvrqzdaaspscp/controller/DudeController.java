package com.example.kwwqxmokvrqzdaaspscp.controller;

import com.example.kwwqxmokvrqzdaaspscp.component.PersonMapper;
import com.example.kwwqxmokvrqzdaaspscp.dto.DudeDTO;
import com.example.kwwqxmokvrqzdaaspscp.entity.Dude;
import com.example.kwwqxmokvrqzdaaspscp.service.DudeService;
import com.example.kwwqxmokvrqzdaaspscp.util.PersonException.PersonNotCreatedException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dude")
public class DudeController {
    private final PersonMapper mapper;
    @Autowired
    private final DudeService dudeService;
    public DudeController(PersonMapper mapper, DudeService dudeService){
        this.mapper = mapper;
        this.dudeService = dudeService;
    }
    @GetMapping
    private List<DudeDTO> getAll(){
        return dudeService.getAll().stream().map(mapper::convertToDudeDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    private Optional<Dude> getOneDude(@PathVariable int id){
        return dudeService.getDude(id);
    }
    @PostMapping("/create")
    private ResponseEntity<HttpStatus> createDude(@RequestBody @Valid DudeDTO dudeDTO, BindingResult bindingResult){
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
        dudeService.createDude(mapper.convertToDude(dudeDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    private DudeDTO updateDudeDTO(@PathVariable int id, @RequestBody DudeDTO dudeDTO){
        return dudeService.updateDude(id,dudeDTO);
    }
    @DeleteMapping("/delete/{id}")
    private void deleteDude(@PathVariable int id){
        dudeService.deleteDude(id);
    }
}
