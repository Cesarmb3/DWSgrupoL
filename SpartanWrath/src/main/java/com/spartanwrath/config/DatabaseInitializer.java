package com.spartanwrath.config;

import com.spartanwrath.model.CombatClass;
import com.spartanwrath.model.Membership;
import com.spartanwrath.model.Product;
import com.spartanwrath.model.User;
import com.spartanwrath.repository.ProductRepository;
import com.spartanwrath.service.CombatClassService;
import com.spartanwrath.service.MembershipService;
import com.spartanwrath.service.ProductService;
import com.spartanwrath.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Component
public class DatabaseInitializer {
    @Autowired
    private UserService usersService;
    @Autowired
    private MembershipService membershipService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CombatClassService combatClassService;

    // Map para almacenar los usuarios
    private static final Map<String, User> usersMap = new HashMap<>();
    // Map para almacenar nombres de usuario y contraseñas para autenticación
    private static final Map<String, String> credentialsMap = new HashMap<>();

    // Map para almacenar los usuarios
    @PostConstruct
    public void init() throws IOException {
        //NUEVOS USUARIOS
        User user1 = new User(1L, "Nombre1", "usuario1", "email1@example.com", "Dirección1", "123456789", "type1", "contraseña1", "01/01/2000", "123456789X", "pago1");
        User user2 = new User(2L, "Nombre2", "usuario2", "email2@example.com", "Dirección2", "987654321", "type2", "contraseña2", "02/02/2000", "987654321Y", "pago2");
        User admin = new User(3L, "Admin", "admin", "admin@example.com", "Dirección Admin", "999999999", "admin", "admin123", "03/03/2000", "000000000Z", "pagoAdmin");

        usersMap.put(user1.getUsername(), user1);
        usersMap.put(user2.getUsername(), user2);
        usersMap.put(admin.getUsername(), admin);

        credentialsMap.put(user1.getUsername(), user1.getPassword());
        credentialsMap.put(user2.getUsername(), user2.getPassword());
        credentialsMap.put(admin.getUsername(), admin.getPassword());

        //NuEVOS PRODUCTOS
        Product product1 = new Product("Casco", "Casco de proteccion para sparring", "../../images/casco.jpeg", 10.00, 2, "");
        Product product2 = new Product("Espinilleras", "Espinilleras de proteccion para Kick Boxing/Muai Thai", "../../images/espinilleras.jpg", 12.00, 2, "");
        Product product3 = new Product("Guantes", "Guantes de boxeo 16 Oz de piel sintetica", "../../images/guantes.png", 49.99, 2, "");
        Product product4 = new Product("Vendas", "Vendas 4.5 metros", "../../images/vendas.jpg", 5.99, 2, "");
        Product product5 = new Product("Bucal", "Bucal de proteccion para sparring", "../../images/bucal.jpg", 3.00, 2, "");
        Product product6 = new Product("Proteina", "Whey Protein facilita el proceso", "../../images/proteinas.jpg", 24.99, 2, "");
        //NUEVAS SUSCRIPCIONES
        Date date1 = new Date(1,1,2025);
        Date date2 = new Date(1,2,2025);
        Membership membership1 = new Membership(1L,"1 mes","Acceso a todas las clases durante 1 mes",50.00, date1,date2,true);

        //NUEVAS CLASES
        CombatClass clase1 = new CombatClass(1L,"Boxeo","Clase de boxeo para principiantes, necesario guantes y vendas", "Lunes por la mañana");
        CombatClass clase2 = new CombatClass(2L,"K1","Clase de K1 para competidores, se requiere experiencia previa,espinilleras necesarias", "Lunes por la tarde");
        CombatClass clase3 = new CombatClass(3L,"Muay Thai","Clase de Muay thai para principiantes, espinilleras no necesarias", "Martes por la mañana");


        //AÑADIMOS COMPRAS A LOS USUARIOS
        user1.setProducts(List.of(product1, product2));
        product1.getUsuarios().add(user1);
        product2.getUsuarios().add(user1);

        user1.setProducts(List.of(product3, product4));
        product3.getUsuarios().add(user2);
        product4.getUsuarios().add(user2);

        //AÑADIMOS SUSCRIPCIONES A LOS USUARIOS
        user1.setMemberships(List.of(membership1));

        //AÑADIMOS SUSCRIPCIONES A LAS CLASES
        clase1.setMemberships(List.of(membership1));

        usersService.save(user1);
        usersService.save(user2);
        usersService.save(admin);

        productService.save(product1,null);
        productService.save(product2,null);
        productService.save(product3,null);
        productService.save(product4,null);
        productService.save(product5,null);
        productService.save(product6,null);

        membershipService.save(membership1);

        combatClassService.save(clase1);
        combatClassService.save(clase2);
        combatClassService.save(clase3);
    }

}


