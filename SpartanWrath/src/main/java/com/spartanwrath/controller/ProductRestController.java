package com.spartanwrath.controller;


import com.spartanwrath.model.Product;
import com.spartanwrath.service.ImageService;
import com.spartanwrath.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api")
public class ProductRestController {

    private static final String PRODUCTS_FOLDER = "products";

    @Autowired
    private ProductService productServ;

    @Autowired
    private ImageService imageServ;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productServ.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Optional<Product>> getProduct(@PathVariable long id) {
        Optional<Product> product = productServ.getProductById(id);
        if (product.isPresent()){
            return ResponseEntity.ok().body(product);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        productServ.createProduct(product);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(location).body(product);
    }

    @PostMapping("/products/{id}/imagen")
    public ResponseEntity<Object> uploadImage(@PathVariable long id, @RequestParam MultipartFile imageFile) throws IOException{
        Optional<Product> productOptional = productServ.getProductById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            URI location = fromCurrentRequest().build().toUri();

            product.setImagen(location.toString());
            productServ.updateProduct(product);

            imageServ.saveImage(PRODUCTS_FOLDER,product.getId(),imageFile);
            return ResponseEntity.created(location).build();
        }else {
            return ResponseEntity.notFound().build();
        }


    }


}