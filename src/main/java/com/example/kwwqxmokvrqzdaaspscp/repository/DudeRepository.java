package com.example.kwwqxmokvrqzdaaspscp.repository;

import com.example.kwwqxmokvrqzdaaspscp.entity.Dude;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DudeRepository extends MongoRepository<Dude, Integer> {

}
