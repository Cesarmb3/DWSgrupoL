package com.spartanwrath.controller;

import com.spartanwrath.model.Producto;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MarketController {
    private List<Producto> productos = new ArrayList<>();
    public MarketController() {
        productos.add(new Producto(1,"Casco","Casco de proteccion para sparring","../images/casco.jepg",10.00));
        productos.add(new Producto(2,"Espinilleras","Espinilleras de proteccion para Kick Boxing/Muai Thai","../images/espinilleras.jpg",12.00));
        productos.add(new Producto(3,"Guantes","Guantes de boxeo 16 Oz de piel sintetica","../images/guantes.png",49.99));
        productos.add(new Producto(4,"Vendas","Vendas 4.5 metros","../images/vendas.jpg",5.99));
        productos.add(new Producto(5,"Bucal","Bucal de proteccion para sparring","../images/bucal.jpg",3.00));
        productos.add(new Producto(6,"Proteina","Whey Protein facilita el proceso","../images/proteina.jpg",24.99));
    }


}