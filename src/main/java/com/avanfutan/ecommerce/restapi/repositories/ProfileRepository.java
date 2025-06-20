package com.avanfutan.ecommerce.restapi.repositories;

import com.avanfutan.ecommerce.restapi.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
