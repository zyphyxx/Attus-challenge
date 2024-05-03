package com.attus.challenge.entities;


import com.attus.challenge.enums.MainAdress;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O cep não pode estar vazio")
    @Size(min = 8, max = 8, message = "O cep não ter o tamanho menor que 8 digitos")
    private String zipCode;

    private String city;

    private String country;

    private String Street;

    private Integer number;

    @Enumerated(EnumType.STRING)
    private MainAdress mainAdress;

    @ManyToOne
    private Person person;


}
