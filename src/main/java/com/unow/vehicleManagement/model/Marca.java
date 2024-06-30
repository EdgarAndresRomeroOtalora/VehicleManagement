package com.unow.vehicleManagement.model;

import java.util.List;

public class Marca {

    private Integer id;

    private String nombreMarca;

    private Modelo modelo;

    public Marca() {
    }

    public Marca(Integer id, String nombreMarca, Modelo modelo) {
        this.id = id;
        this.nombreMarca = nombreMarca;
        this.modelo = modelo;
    }

    public Marca(String nombreMarca, Modelo modelo) {
        this.nombreMarca = nombreMarca;
        this.modelo = modelo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
}
