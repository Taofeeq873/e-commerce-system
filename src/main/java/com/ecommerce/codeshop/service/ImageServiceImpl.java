package com.ecommerce.codeshop.service;

import com.ecommerce.codeshop.Exception.FileStorageException;
import com.ecommerce.codeshop.model.Image;
import com.ecommerce.codeshop.model.Product;
import com.ecommerce.codeshop.repository.ImageRepository;
import com.ecommerce.codeshop.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
@Service
public class ImageServiceImpl implements IImageService{

    final
    ProductRepository productRepository;
    final
    ImageRepository imageRepository;

    public ImageServiceImpl(ProductRepository productRepository, ImageRepository imageRepository) {
        this.productRepository = productRepository;
        this.imageRepository = imageRepository;
    }

    private final String UPLOAD_DIR = "C:\\Users\\HP\\IdeaProjects\\codeshop\\src\\main\\resources\\static\\uploads";

    public void createImage(long productId, MultipartFile file){
        Image image = new Image();
        Product product = productRepository.findById(productId).get();
        image.setProduct(product);

        try {
            //String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            String fileName = UUID.randomUUID().toString();// Generate Universally Unique Identifier and convert to string...
            Path imagePath = Paths.get(UPLOAD_DIR + File.separator + fileName);
            Files.copy(file.getInputStream(),imagePath, StandardCopyOption.REPLACE_EXISTING);
            image.setUrl(fileName);

        } catch (IOException e) {
            e.printStackTrace();
            throw new FileStorageException("File Not Found");
        }
        imageRepository.save(image);
    }
}
