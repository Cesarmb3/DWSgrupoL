package com.spartanwrath.controller;

import com.spartanwrath.model.Product;
import com.spartanwrath.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class MarketController {
    @Autowired
    private ProductService productService;

    @GetMapping("/Market")
    public String showMarket(){
        return "market";
    }
    @GetMapping("/Market/products/formproducto")
    public String showForm(){
        return "formproducto";
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

    @PostMapping("/nuevoproducto")
    public String newBookProcess(Model model, Product product, MultipartFile imageField) throws IOException {

        Product newproduct = productService.save(product, imageField);

        model.addAttribute("bookId", newproduct.getId());

        return "redirect:/Market/products/"+newproduct.getId();
    }
}
