package com.spartanwrath.service;

import com.spartanwrath.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class ProductService {

    @Autowired
    private ImageService imageService;

    private AtomicLong nextId = new AtomicLong(1L);
    private ConcurrentHashMap<Long, Product> productos = new ConcurrentHashMap<>();

    public Optional<Product> findById(long id) {
        if(this.productos.containsKey(id)) {
            return Optional.of(this.productos.get(id));
        }
        return Optional.empty();
    }

    public boolean exist(long id) {
        return this.productos.containsKey(id);
    }

    public List<Product> findAll() {
        return this.productos.values().stream().toList();
    }

    public Product save(Product product, MultipartFile imageField) {

        if (imageField != null && !imageField.isEmpty()){
            String path = imageService.createImage(imageField);
            product.setImagen(path);
        }

        if(product.getImagen() == null || product.getImagen().isEmpty()) product.setImagen("no-image.png");

        long id = nextId.getAndIncrement();
        product.setId(id);
        productos.put(id, product);
        return product;
    }
}