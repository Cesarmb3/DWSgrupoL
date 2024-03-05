package com.spartanwrath.model;

import java.util.Date;

public class sala {
        private Integer id;
        private String nombre;
        private String clase;
        private Date horaclase;
        private String descripcion;
        private String imagen;

    public sala() {
    }

    public sala(Integer id, String nombre, String clase, Date horaclase, String descripcion, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.clase = clase;
        this.horaclase = horaclase;
        this.descripcion = descripcion;
        this.imagen = imagen;
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

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Date getHoraclase() {
        return horaclase;
    }

    public void setHoraclase(Date horaclase) {
        this.horaclase = horaclase;
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

    @Override
    public String toString() {
        return "sala{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", clase='" + clase + '\'' +
                ", horaclase=" + horaclase +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
