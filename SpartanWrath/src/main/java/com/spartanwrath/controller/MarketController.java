package com.spartanwrath.controller;

import com.spartanwrath.model.Product;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MarketController {
    private List<Product> products = new ArrayList<>();
    public MarketController() {
        products.add(new Product("Casco","Casco de proteccion para sparring","../images/casco.jepg",10.00,2,""));
        products.add(new Product("Espinilleras","Espinilleras de proteccion para Kick Boxing/Muai Thai","../images/espinilleras.jpg",12.00,2,""));
        products.add(new Product("Guantes","Guantes de boxeo 16 Oz de piel sintetica","../images/guantes.png",49.99,2,""));
        products.add(new Product("Vendas","Vendas 4.5 metros","../images/vendas.jpg",5.99,2,""));
        products.add(new Product("Bucal","Bucal de proteccion para sparring","../images/bucal.jpg",3.00,2,""));
        products.add(new Product("Proteina","Whey Protein facilita el proceso","../images/proteina.jpg",24.99,2,""));
    }


}