package com.ecommerce.codeshop.service;

import com.ecommerce.codeshop.model.Image;
import com.ecommerce.codeshop.model.Product;
import org.springframework.web.multipart.MultipartFile;

public interface IImageService {

    public void createImage(long productId, MultipartFile file);
}
