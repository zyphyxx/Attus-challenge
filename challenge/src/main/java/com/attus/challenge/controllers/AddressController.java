package com.attus.challenge.controllers;

import com.attus.challenge.dtos.Mapper;
import com.attus.challenge.dtos.address.AddressReponse;
import com.attus.challenge.dtos.address.AddressRequest;
import com.attus.challenge.entities.Address;
import com.attus.challenge.services.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/create/{id}")
    public ResponseEntity<AddressReponse> addAddress(@RequestBody AddressRequest request, @PathVariable Long id) {
        try {
            Address address = Mapper.toAddress(request);
            addressService.addAddress(address, id);
            return ResponseEntity.status(HttpStatus.CREATED).body(Mapper.toResponseAddress(address));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AddressReponse> updateAddress(@PathVariable Long id, @RequestBody AddressRequest request) {
        try {
            Address address = Mapper.toAddress(request);
            addressService.updateAddress(id,address);
            return ResponseEntity.status(HttpStatus.OK).body(Mapper.toResponseAddress(address));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<AddressReponse> findAddressByID(@PathVariable Long id) {
        Optional<Address> addressByID = addressService.findAddressByID(id);
        if (addressByID.isPresent()) {
            Address address = addressByID.get();
            return ResponseEntity.status(HttpStatus.OK).body(Mapper.toResponseAddress(address));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<AddressReponse>> findAllAddress() {
        try {
            List<Address> allAddress = addressService.findAllAddress();
            return ResponseEntity.status(HttpStatus.OK).body(Mapper.toListAddress(allAddress));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }



}
