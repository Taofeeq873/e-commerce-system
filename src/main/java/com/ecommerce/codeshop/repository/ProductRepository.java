package com.ecommerce.codeshop.repository;

import com.ecommerce.codeshop.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

//    @Query(value = "select p.* from product p left join product_category pc on pc.product_id=p.id left join category c on pc.category_id=c.id where c.id = :id", nativeQuery = true)
    @Query(value = "select p.* from product p inner join product_category pc on pc.product_id=p.id where pc.category_id = :id", nativeQuery = true)
    List<Product> findProductsByCategoryId(int id);

//    @Query(value = "SELECT * FROM products p WHERE p.name LIKE $%{searchText}% ", nativeQuery = true)
//    List<Product> search(String keyword);

    @Query(value = "SELECT p.* FROM product p where p.name like %:searchText% ", nativeQuery = true)
    List<Product> search(String searchText);


}
