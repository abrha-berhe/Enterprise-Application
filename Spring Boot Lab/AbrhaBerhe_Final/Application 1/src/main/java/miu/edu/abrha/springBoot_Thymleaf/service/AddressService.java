package miu.edu.abrha.springBoot_Thymleaf.service;

import miu.edu.abrha.springBoot_Thymleaf.dao.AddressDao;
import miu.edu.abrha.springBoot_Thymleaf.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressDao addressDao;

    public ResponseEntity<Address> addAddress(Address address) {
        addressDao.save(address);
        return ResponseEntity.status(200).build();
    }

    public List<Address> getAllAddresss() {
        return addressDao.findAll();
    }

    public Address getOneAddress(Long id) {
        return addressDao.findById(id).get();
    }

    public ResponseEntity<Address> updateAddress(Address address) {
        addressDao.save(address);
        return ResponseEntity.status(201).build();
    }

    public ResponseEntity<Address> deleteAddress(Long id) {
        addressDao.deleteById(id);
        return ResponseEntity.status(201).build();
    }
}
