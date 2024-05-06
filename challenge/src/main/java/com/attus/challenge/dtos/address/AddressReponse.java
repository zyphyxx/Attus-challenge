package com.attus.challenge.dtos.address;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AddressReponse implements Serializable {

    private String zipCode;

    private String city;

    private String country;

    private String street;

    private Integer number;

    public AddressReponse(String zipCode, String city, String country, String street, Integer number) {
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
        this.street = street;
        this.number = number;
    }
}
