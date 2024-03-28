package com.spartanwrath.repository;

import com.spartanwrath.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.web.multipart.MultipartFile;


import java.util.ArrayList;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();
    List<Product> findByCategory(String category);


}

