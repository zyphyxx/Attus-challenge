package com.attus.challenge.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Address> addressList;

    public Person(Long id, String fullName, String birthDate) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.addressList = new ArrayList<>();
    }
}
