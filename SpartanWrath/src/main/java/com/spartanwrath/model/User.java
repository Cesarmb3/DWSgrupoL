package com.spartanwrath.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Columns;

import java.util.*;

import java.util.HashMap;
import java.util.Map;

public class User {

    private Long id;
    private String name;
    private String username;
    private String email;
    private String address;
    private String phone;
    private String type;
    private String password;
    private String birthday;
    private String dni;
    private String payment;
    private List<Product> products;
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
