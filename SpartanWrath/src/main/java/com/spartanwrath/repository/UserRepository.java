package com.spartanwrath.repository;

import com.spartanwrath.model.Product;
import com.spartanwrath.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
    List<User> findByCategory(String category);
}
