package com.avanfutan.ecommerce.restapi.repositories;

import com.avanfutan.ecommerce.restapi.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
