package com.spartanwrath.config;

import com.spartanwrath.model.Product;
import com.spartanwrath.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ProductStaticInitializer {

    private final ProductRepository productRepository;

    @Autowired
    public ProductStaticInitializer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void initializeStaticProducts() {
        List<Product> staticProducts = new ArrayList<>();
        staticProducts.add(new Product("Casco", "Casco de proteccion para sparring", "../../images/casco.jpeg", 10.00, 2, ""));
        staticProducts.add(new Product("Espinilleras", "Espinilleras de proteccion para Kick Boxing/Muai Thai", "../../images/espinilleras.jpg", 12.00, 2, ""));
        staticProducts.add(new Product("Guantes", "Guantes de boxeo 16 Oz de piel sintetica", "../../images/guantes.png", 49.99, 2, ""));
        staticProducts.add(new Product("Vendas", "Vendas 4.5 metros", "../../images/vendas.jpg", 5.99, 2, ""));
        staticProducts.add(new Product("Bucal", "Bucal de proteccion para sparring", "../../images/bucal.jpg", 3.00, 2, ""));
        staticProducts.add(new Product("Proteina", "Whey Protein facilita el proceso", "../../images/proteinas.jpg", 24.99, 2, ""));

        productRepository.saveAll(staticProducts);
    }
}
