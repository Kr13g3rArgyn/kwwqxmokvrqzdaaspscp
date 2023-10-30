package com.example.kwwqxmokvrqzdaaspscp.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Filter {
    private int limit;
    private int offset;
}
