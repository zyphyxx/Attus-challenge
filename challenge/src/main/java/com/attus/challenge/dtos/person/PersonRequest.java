package com.attus.challenge.dtos.person;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class PersonRequest implements Serializable {

    private Long id;

    @NotBlank(message = "O nome não pode esta vazio")
    private String fullName;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotBlank(message = "A data de aniversario não pode estar vazia")
    private LocalDate birthDate;
}
