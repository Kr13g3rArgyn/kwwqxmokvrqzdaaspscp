package com.example.kwwqxmokvrqzdaaspscp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
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
    @Column(name = "name")
    private String name;
    @Max(2020)
    private int birthYear;
    @Column(name = "firstPhoneNum")
    private long firstPhoneNum;
    @Column(name = "secondPhoneNum")
    private long secondPhoneNum;
    private LocalDateTime createdAt;
}
