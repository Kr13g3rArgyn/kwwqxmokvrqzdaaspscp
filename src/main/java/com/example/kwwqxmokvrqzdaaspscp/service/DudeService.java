package com.example.kwwqxmokvrqzdaaspscp.service;

import com.example.kwwqxmokvrqzdaaspscp.component.PersonMapper;
import com.example.kwwqxmokvrqzdaaspscp.dto.DudeDTO;
import com.example.kwwqxmokvrqzdaaspscp.entity.Dude;
import com.example.kwwqxmokvrqzdaaspscp.repository.DudeRepository;
import com.example.kwwqxmokvrqzdaaspscp.util.PersonException.PersonNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DudeService {
    @Autowired
    private DudeRepository dudeRepository;
    private PersonMapper personMapper;
    public DudeService(DudeRepository dudeRepository){
        this.dudeRepository = dudeRepository;
    }
    public List<Dude> getAll(){
        return dudeRepository.findAll();
    }
    public Optional<Dude> getDude(int id){
        return dudeRepository.findById(id);
    }
    public DudeDTO updateDude(int id, DudeDTO updatedDude){
        Optional<Dude> existingDude = dudeRepository.findById(id);
        if (existingDude.isPresent()) {
            Dude dudeToUpdate = existingDude.get();
            dudeToUpdate.setName(updatedDude.getName());
            dudeToUpdate.setFirstPhoneNum(updatedDude.getFirstPhoneNum());
            dudeToUpdate.setSecondPhoneNum(updatedDude.getSecondPhoneNum());
            dudeRepository.save(dudeToUpdate);
            return personMapper.convertToDudeDTO(dudeToUpdate);
        }
        else {
            throw new PersonNotFoundException(id);
        }
    }
    @Transactional
    public Dude createDude(Dude dude){
        return dudeRepository.save(dude);
    }
    public void deleteDude(int id){
        dudeRepository.deleteById(id);
    }

}
