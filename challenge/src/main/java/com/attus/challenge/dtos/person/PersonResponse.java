package com.attus.challenge.dtos.person;

import com.attus.challenge.entities.Address;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PersonResponse implements Serializable {

    private Long id;

    private String fullName;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    private List<Address> addressList;
}
