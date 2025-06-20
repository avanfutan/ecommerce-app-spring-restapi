package com.avanfutan.ecommerce.restapi.repositories;

import com.avanfutan.ecommerce.restapi.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
