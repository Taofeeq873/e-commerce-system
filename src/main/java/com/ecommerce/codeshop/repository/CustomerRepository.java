package com.ecommerce.codeshop.repository;

import com.ecommerce.codeshop.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
    Optional<Customer> findByUsername(String username);
    boolean   existsByUsername(String username);
    Customer findCustomerByUsername(String username);
}
