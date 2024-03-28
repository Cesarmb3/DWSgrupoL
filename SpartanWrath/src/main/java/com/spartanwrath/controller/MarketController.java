package com.spartanwrath.controller;

import com.spartanwrath.model.Product;
import com.spartanwrath.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class MarketController {
    @Autowired
    private ProductService productService;

    @GetMapping("/Market")
    public String showMarket(){
        return "market";
    }

    @GetMapping("/Market/products")
    public String showProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("/Market/products/{id}")
    public String showProduct(Model model, @PathVariable long id) {

        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "product";
        } else {
            return "products";
        }
    }

    @GetMapping("/Market/products/{id}/delete")
    public String deletePost(Model model, @PathVariable long id) {

        productService.delete(id);

        return "products";
    }
}
