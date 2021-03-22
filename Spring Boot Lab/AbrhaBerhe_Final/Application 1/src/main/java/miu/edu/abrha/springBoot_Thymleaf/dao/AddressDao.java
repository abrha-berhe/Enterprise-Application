package miu.edu.abrha.springBoot_Thymleaf.dao;

import miu.edu.abrha.springBoot_Thymleaf.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Address, Long> {
}


