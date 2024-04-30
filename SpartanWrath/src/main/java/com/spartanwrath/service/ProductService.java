package com.spartanwrath.service;

import com.spartanwrath.model.Product;
import com.spartanwrath.repository.ProductRepository;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    private ImageService imageService;

    @Value("${image.upload.dir}")
    private String uploadDir;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Método para crear un nuevo producto
    public Product createProduct(Product product) throws IOException {

        if(product.getImagen() == null || product.getImagen().length == 0){
            byte[] defaultImageData = imageService.getDefault();
            product.setImagen(defaultImageData);
            product.setOriginalImageName(imageService.getDefaultName());
        }else {
            byte[] imageData = product.getImagen();
            product.setImagen(imageData);

        }
        return productRepository.save(product);
    }

    // Método para obtener todos los productos
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Método para obtener un producto por su ID
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }
    // Método para actualizar un producto
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    // Método para eliminar un producto por su ID
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    public void deleteAllProduct(){
        productRepository.deleteAll();
    }

    public List<Product> getProductsByIds(List<Long> productIds){
        List<Product> products = new ArrayList<>();
        for (Long productId : productIds){
            Optional<Product> optionalProduct = productRepository.findById(productId);
            optionalProduct.ifPresent(products::add);
        }
        return products;
    }

}