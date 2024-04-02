package com.spartanwrath.config;

import com.spartanwrath.exceptions.InvalidUser;
import com.spartanwrath.exceptions.UserAlreadyRegister;
import com.spartanwrath.model.CombatClass;
import com.spartanwrath.model.Membership;
import com.spartanwrath.model.Product;
import com.spartanwrath.model.User;
import com.spartanwrath.service.CombatClassService;
import com.spartanwrath.service.MembershipService;
import com.spartanwrath.service.ProductService;
import com.spartanwrath.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



@Configuration
public class DatabaseInitializer {

    @Autowired
    private UserService usersService;
    @Autowired
    private MembershipService membershipService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CombatClassService combatClassService;
    @PostConstruct
    public void init() throws IOException,UserAlreadyRegister, InvalidUser {
        //NUEVOS USUARIOS
        try {
        User user1 = new User( "Nombre1", "usuario1", "email1@example.com", "Dirección1", 123456789, "contraseña1",  "12345678M", "pago1");
        usersService.add(user1);
        //NuEVOS PRODUCTOS
        Product product1 = new Product("Casco", "Casco de proteccion para sparring", "../../images/casco.jpeg", 10.00, 2, "Cascos");
        Product product2 = new Product("Espinilleras", "Espinilleras de proteccion para Kick Boxing/Muai Thai", "../../images/espinilleras.jpg", 12.00, 2, "");
        Product product3 = new Product("Guantes", "Guantes de boxeo 16 Oz de piel sintetica", "../../images/guantes.png", 49.99, 2, "Guantes");
        Product product4 = new Product("Vendas", "Vendas 4.5 metros", "../../images/vendas.jpg", 5.99, 2, "");
        Product product5 = new Product("Bucal", "Bucal de proteccion para sparring", "../../images/bucal.jpg", 3.00, 2, "");
        Product product6 = new Product("Proteina", "Whey Protein facilita el proceso", "../../images/proteinas.jpg", 24.99, 2, "");
        //NUEVAS SUSCRIPCIONES
        LocalDate date1 = LocalDate.of(2025, 1, 1); // 1 de enero de 2025
        LocalDate date2 = LocalDate.of(2025, 2, 1); // 1 de febrero de 2025
        Membership membership1 = new Membership(1L, "1 mes", "Acceso a todas las clases durante 1 mes", 50.00, date1, date2, true,user1);

        //NUEVAS CLASES
        CombatClass clase1 = new CombatClass(1L,"Boxeo","Clase de boxeo para principiantes, necesario guantes y vendas", "Lunes por la mañana");
        CombatClass clase2 = new CombatClass(2L,"K1","Clase de K1 para competidores, se requiere experiencia previa,espinilleras necesarias", "Lunes por la tarde");
        CombatClass clase3 = new CombatClass(3L,"Muay Thai","Clase de Muay thai para principiantes, espinilleras no necesarias", "Martes por la mañana");



        productService.createProduct(product1);
        productService.createProduct(product2);
        productService.createProduct(product3);
        productService.createProduct(product4);
        productService.createProduct(product5);
        productService.createProduct(product6);

        membershipService.save(membership1);

        combatClassService.save(clase1);
        combatClassService.save(clase2);
        combatClassService.save(clase3);

            // Establecer los productos asociados al usuario utilizando setProducts
            List<Product> userProducts = new ArrayList<>();
            userProducts.add(product1);  // Agregar el producto a la lista de productos del usuario
            user1.setProducts(userProducts);  // Establecer la lista completa de productos asociados al usuario

            product1.getUsuarios().add(user1); // Agregar usuario al producto


            System.out.println("Usuarios asociados al producto 1:");
            for (User user : product1.getUsuarios()) {
                System.out.println(user.getName());
            }

// Imprimir los productos asociados al usuario
            System.out.println("Productos asociados al usuario 1:");
            for (Product product : user1.getProducts()) {
                System.out.println(product.getNombre());
            }



        //AÑADIMOS SUSCRIPCIONES A LOS USUARIOS
        /*user1.setMemberships(List.of(membership1));

        //AÑADIMOS SUSCRIPCIONES A LAS CLASES
        clase1.setMemberships(List.of(membership1));*/
    } catch (UserAlreadyRegister | InvalidUser ex){
            throw ex;
        }

    }
}


