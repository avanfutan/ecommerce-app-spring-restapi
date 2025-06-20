package com.avanfutan.ecommerce.restapi.repositories;

import com.avanfutan.ecommerce.restapi.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
