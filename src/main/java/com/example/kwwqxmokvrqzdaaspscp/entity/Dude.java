package com.example.kwwqxmokvrqzdaaspscp.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
//FOR MONGO DB
@Data
@NoArgsConstructor
@Document(collection = "greetgo")
public class Dude {
    private Integer id;
    @Size(min = 0,max = 30,message = "min - 0, max - 30 characters")
    private String name;
    @Max(2020)
    private int birthYear;
    private long firstPhoneNum;
    private long secondPhoneNum;
    private LocalDateTime createdAt;

}
