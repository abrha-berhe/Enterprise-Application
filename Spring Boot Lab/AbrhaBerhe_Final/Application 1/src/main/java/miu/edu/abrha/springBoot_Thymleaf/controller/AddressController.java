package miu.edu.abrha.springBoot_Thymleaf.controller;

import miu.edu.abrha.springBoot_Thymleaf.model.Address;
import miu.edu.abrha.springBoot_Thymleaf.model.Author;
import miu.edu.abrha.springBoot_Thymleaf.model.Book;
import miu.edu.abrha.springBoot_Thymleaf.service.AddressService;
import miu.edu.abrha.springBoot_Thymleaf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/")
    public List<Address> getAllAddresss() {
        return addressService.getAllAddresss();
    }


    @PostMapping("/")

    public ResponseEntity<Address> addAddresss(@RequestBody Address address) {
        return addressService.addAddress(address);
    }

    @GetMapping("/{id}")
    public Address getOneAddress(@PathVariable Long id) {
        Address auth = addressService.getOneAddress(id);
        return auth;
    }

}
