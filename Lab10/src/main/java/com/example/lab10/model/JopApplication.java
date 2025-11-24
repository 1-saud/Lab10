package com.example.lab10.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JopApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int not null")
    private Integer id;

    @NotNull(message = "userId shouldn't be null")
    @Column(columnDefinition = "int not null")
    private Integer userId;

    @NotNull(message = "jobPostId shouldn't be null")
    @Column(columnDefinition = "int not null")
    private Integer jobPostId;

}

