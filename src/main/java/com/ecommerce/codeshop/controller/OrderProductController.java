package com.ecommerce.codeshop.controller;

import com.ecommerce.codeshop.model.OrderProduct;
import com.ecommerce.codeshop.repository.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderProductController {
    @Autowired
    private OrderProductRepository orderProductRepository;

    //Get list of all orderProducts.
    @CrossOrigin(exposedHeaders = "http://localhost:8888")
    @RequestMapping(path = "/orderProducts", method = RequestMethod.GET)
    public List allOrderProducts() {

        return (List) orderProductRepository.findAll();
    }

    //Get the details of a orderProduct.
    @CrossOrigin(exposedHeaders = "http://localhost:8888")
    @RequestMapping(value = "/orderProduct/{id}", method = RequestMethod.GET)
    public OrderProduct orderProductDetails(@PathVariable("id") long id) {
        OrderProduct orderProduct = orderProductRepository.findById(id).get();

        return orderProduct;
    }
}

