package com.ecommerce.codeshop.service;


import com.ecommerce.codeshop.model.Category;
import com.ecommerce.codeshop.model.Product;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IProductService {

    public List products(int id);
    public Product createProduct(String name, double price, List<String> categories, MultipartFile file, String description);

}
