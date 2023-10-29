package com.example.kwwqxmokvrqzdaaspscp.entity;

import jakarta.persistence.*;
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
    private String name;
    private int birthYear;
    private long firstPhoneNum;
    private long secondPhoneNum;
    private LocalDateTime createdAt;
}
