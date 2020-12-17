package com.ecommerce.codeshop.repository;

import com.ecommerce.codeshop.model.OrderProduct;
import org.springframework.data.repository.CrudRepository;

public interface OrderProductRepository extends CrudRepository<OrderProduct, Long> {
//    OrderProduct findById(long id);
}
