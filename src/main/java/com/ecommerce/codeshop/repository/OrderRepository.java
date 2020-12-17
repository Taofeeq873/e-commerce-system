package com.ecommerce.codeshop.repository;

import com.ecommerce.codeshop.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
