package com.example.lab10.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int not null")
    private Integer id;

    @NotBlank
    @Size(min = 5, message = "must be more than 4 characters")
    @Pattern(regexp = "^[A-Za-z]+$", message = "letters only")
    @Column(columnDefinition = "not null check (length(name) > 4)")
    private String name;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Column(columnDefinition = "not null")
    private String password;

    @NotNull
    @Min(value = 22, message = "age should be more than 21")
    @Column(columnDefinition = "int not null check (age > 21)")
    private Integer age;

    @NotBlank
    @Pattern(regexp = "JOB_SEEKER|EMPLOYER", message = "role must be JOB_SEEKER or EMPLOYER")
    @Column(columnDefinition = "not null")
    private String role;

}
