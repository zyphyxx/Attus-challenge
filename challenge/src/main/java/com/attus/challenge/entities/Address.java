package com.attus.challenge.entities;


import com.attus.challenge.enums.MainAdress;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String zipCode;

    private String city;

    private String country;

    private String street;

    private Integer number;

    @Enumerated(EnumType.STRING)
    private MainAdress mainAdress;

    @ManyToOne
    @JoinColumn
    private Person person;

    public Address(String zipCode, String city, String country, String street, int number,Person id) {
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
        this.street = street;
        this.number = number;
        this.person = id;
    }
    public Address(String zipCode, String city, String country, String street, Integer number) {
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
        this.street = street;
        this.number = number;
    }
}
