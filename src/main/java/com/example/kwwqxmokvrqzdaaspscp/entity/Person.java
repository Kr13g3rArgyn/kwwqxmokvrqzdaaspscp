package com.example.kwwqxmokvrqzdaaspscp.entity;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {
    private Integer id;
    private String name;
    private int birthYear;
    private long firstPhoneNum;
    private long secondPhoneNum;
    private LocalDateTime createdAt;
}
