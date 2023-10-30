package com.example.kwwqxmokvrqzdaaspscp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
@Data
@Entity
@NoArgsConstructor
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 0,max = 30,message = "min - 0, max - 30 characters")
    private String name;
    @Min(1900)
    @Max(2020)
    private int birthYear;
    private long firstPhoneNum;
    private long secondPhoneNum;
    private LocalDateTime createdAt;
}
