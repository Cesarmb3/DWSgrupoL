package com.spartanwrath.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Membership {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
    @Column(name = "nombre")
        private String nombre;
    @Column(name = "descripcion")
        private String descripcion;
    @Column(name = "precio")
        private double precio;
    @Column(name = "fechaalta")
        private Date fechaalta;
    @Column(name = "fechafin")
        private Date fechafin;
    @Column(name = "active")
        private boolean active;

        public Membership() {

        }

    public Membership(Long id, String nombre, String descripcion, double precio, Date fechaalta, Date fechafin, boolean active) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaalta = fechaalta;
        this.fechafin = fechafin;
        this.active = active;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(Date fechaalta) {
        this.fechaalta = fechaalta;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Membership{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", fechaalta=" + fechaalta +
                ", fechafin=" + fechafin +
                ", active=" + active +
                '}';
    }
}
