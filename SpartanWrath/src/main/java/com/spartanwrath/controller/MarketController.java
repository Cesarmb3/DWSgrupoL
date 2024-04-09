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

    private final ProductService productService;
    @Autowired
    public MarketController(ProductService productService) {
        this.productService = productService;
    }

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
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("products", productList);
        return "products";
    }

    @GetMapping("/Market/products/{id}")
    public String showProduct(@PathVariable("id") Long id, Model model) {

        Optional<Product> productOptional = productService.getProductById(id);
        if (productOptional.isPresent()) {
            model.addAttribute("product", productOptional.get());
            return "product";
        } else {
            return "error";
        }
    }

    @GetMapping("/Market/products/{id}/delete")
    public String deletePost(Model model, @PathVariable Long id) {

        productService.deleteProduct(id);

        return "products";
    }

    @PostMapping("/nuevoproducto")
    public String newProducto(Model model, Product product, MultipartFile imageField) throws IOException {


        Product newproduct = productService.createProduct(product);

        model.addAttribute("productId", newproduct.getId());

        return "redirect:/Market/products/"+newproduct.getId();
    }
    @PutMapping("/Market/products/{id}")
    public String updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        Optional<Product> productData = productService.getProductById(id);
        if (productData.isPresent()) {
            Product _product = productData.get();
            _product.setNombre(product.getNombre());
            _product.setDescripcion(product.getDescripcion());
            _product.setPrecio(product.getPrecio());
            _product.setImagen(product.getImagen());
            _product.setCantidad(product.getCantidad());
            _product.setCategory(product.getCategory());
            productService.updateProduct(_product);
            return "redirect:/api/Market/products";
        }else {
            return "redirect:/error";
        }
    }

    @DeleteMapping("/Market/products/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return "redirect:/api/Market/products";
    }
    @DeleteMapping("/Market/products")
    public String deleteProduct(){
        productService.deleteAllProduct();
        return "redirect:/api/Market/products";
    }
}
