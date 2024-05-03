package com.attus.challenge.entities;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode esta vazio")
    private String fullName;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotBlank(message = "A data de aniversario não pode estar vazia")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Address> addressList = new ArrayList<>();


}
