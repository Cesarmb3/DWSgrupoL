package com.spartanwrath.model;

<<<<<<<< Updated upstream:SpartanWrath/src/main/java/com/spartanwrath/model/Producto.java
public class Producto {
    private Integer id;
========
import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nombre")
>>>>>>>> Stashed changes:SpartanWrath/src/main/java/com/spartanwrath/model/Product.java
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "precio")
    private double precio;
    @Column(name = "cantidad")
    private Integer cantidad;

<<<<<<<< Updated upstream:SpartanWrath/src/main/java/com/spartanwrath/model/Producto.java
    public Producto() {

    }

    public Producto(Integer id, String nombre, String descripcion, String imagen, double precio) {
========
    private String category;
    public Product() {

    }

    public Product( String nombre, String descripcion, String imagen, double precio, Integer cantidad, String category) {
>>>>>>>> Stashed changes:SpartanWrath/src/main/java/com/spartanwrath/model/Product.java
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
<<<<<<<< Updated upstream:SpartanWrath/src/main/java/com/spartanwrath/model/Producto.java
========
        this.cantidad = cantidad;
        this.category = category;
>>>>>>>> Stashed changes:SpartanWrath/src/main/java/com/spartanwrath/model/Product.java
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

<<<<<<<< Updated upstream:SpartanWrath/src/main/java/com/spartanwrath/model/Producto.java
========
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
>>>>>>>> Stashed changes:SpartanWrath/src/main/java/com/spartanwrath/model/Product.java

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", category='" + category + '\'' +
                '}';
    }
}
