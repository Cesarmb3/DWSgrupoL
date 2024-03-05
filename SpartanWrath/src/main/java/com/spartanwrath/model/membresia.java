package com.spartanwrath.model;

import java.util.Date;

public class membresia {

        private Integer id;
        private String nombre;
        private String descripcion;
        private double precio;
        private Date fechaalta;
        private Date fechafin;

        public membresia() {

        }

    public membresia(Integer id, String nombre, String descripcion, double precio, Date fechaalta, Date fechafin) {
        super();
            this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaalta = fechaalta;
        this.fechafin = fechafin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        return "membresia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", fechaalta=" + fechaalta +
                ", fechafin=" + fechafin +
                '}';
    }
}
