package com.ecommerce.codeshop.repository;

import com.ecommerce.codeshop.model.Product;
import com.ecommerce.codeshop.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Optional<Role> findByName(String name);

}
