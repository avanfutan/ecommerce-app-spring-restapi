package com.avanfutan.ecommerce.restapi.repositories;

import com.avanfutan.ecommerce.restapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
