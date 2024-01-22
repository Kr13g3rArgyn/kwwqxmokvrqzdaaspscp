package com.example.kwwqxmokvrqzdaaspscp.dto;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DudeDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 3, max = 40, message = "Name should be between 3 and 40 characters")
    @Column(name = "name", nullable = false)
    private String name;
    private long firstPhoneNum;
    private long secondPhoneNum;
    @Column(name = "birth_year")
    private int birth_year;

}
