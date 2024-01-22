package com.example.kwwqxmokvrqzdaaspscp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
//FOR MONGO DB
@Data
@NoArgsConstructor
@Document(collection = "greetgo")
public class Dude {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 0,max = 30,message = "min - 0, max - 30 characters")
    private String name;
    @Max(2020)
    private int birth_year;
    @Column(name = "first_phone_num")
    private long firstPhoneNum;
    @Column(name = "second_phone_num")
    private long secondPhoneNum;
    private LocalDateTime createdAt;

}
