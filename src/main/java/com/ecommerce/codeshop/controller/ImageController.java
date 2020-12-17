package com.ecommerce.codeshop.controller;

import com.ecommerce.codeshop.service.ImageServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@RestController
public class ImageController {
    final ImageServiceImpl imageServiceImpl;

    public ImageController(ImageServiceImpl imageServiceImpl) {
        this.imageServiceImpl = imageServiceImpl;
    }

    //Add more Images to a product.
    @CrossOrigin(exposedHeaders = "http://localhost:8888")
    @RequestMapping(value = "/images/add", method = RequestMethod.POST)
    public String addImages(@RequestParam long productId, @RequestParam("files") MultipartFile[] files){
        Arrays.asList(files).stream()
                .forEach(file -> imageServiceImpl.createImage(productId, file));

        return "Creation Successful";
    }
}
