package com.spartanwrath.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Columns;

import java.util.*;

import java.util.HashMap;
import java.util.Map;
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "type")
    private String type;
    @Column(name = "password")
    private String password;
    @Column(name = "birthday")
    private String birthday;
    @Column(name = "dni")
    private String dni;
    @Column(name = "payment")
    private String payment;
    @ManyToMany
    @JoinTable(
            name = "user_product",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    @OneToMany(mappedBy = "user")
    private List<Membership> memberships;

    public User() {
    }

    public User(Long id, String name, String username, String email, String address, String phone, String type, String password, String birthday, String dni, String payment) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.type = type;
        this.password = password;
        this.birthday = birthday;
        this.dni = dni;
        this.payment = payment;
        this.products = new ArrayList<>();
        this.memberships = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Membership> getMemberships() {
        return memberships;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setMemberships(List<Membership> memberships) {
        this.memberships = memberships;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", type='" + type + '\'' +
                ", password='" + password + '\'' +
                ", birthday='" + birthday + '\'' +
                ", dni='" + dni + '\'' +
                ", payment='" + payment + '\'' +
                ", products=" + products +
                ", memberships=" + memberships +
                '}';
    }
}
