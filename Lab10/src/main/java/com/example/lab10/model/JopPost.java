package com.example.lab10.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class JopPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column //(columnDefinition = "int not null")
    private Integer id;

    @NotBlank(message = " ")
    @Size(min = 5, message = "length should be more than 4")
    @Column //(columnDefinition = " not null check (length(title) > 4)")
    private String title;

    @NotBlank
    @Column //(columnDefinition = "not null")
    private String description;

    @NotBlank
    @Column //(columnDefinition = "not null")
    private String location;

    @NotNull
    @PositiveOrZero
    @Column //(columnDefinition = "double not null")
    private Double salary;

    @Column //(columnDefinition = "date")
    private LocalDate postingDate;
}



