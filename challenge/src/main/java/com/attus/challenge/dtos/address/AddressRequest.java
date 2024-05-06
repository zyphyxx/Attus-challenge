package com.attus.challenge.dtos.address;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
public class AddressRequest implements Serializable {

    @NotBlank(message = "O cep não pode estar vazio")
    @Size(min = 8, max = 8, message = "O cep não ter o tamanho menor que 8 digitos")
    private String zipCode;

    private String city;

    private String country;

    private String street;

    private Integer number;


}
