package com.unow.vehicleManagement.model;

public class Modelo {

    private Integer id;

    private String nombreModelo;

    private String colorModelo;

    public Modelo() {
    }

    public Modelo(Integer id, String nombreModelo, String colorModelo) {
        this.id = id;
        this.nombreModelo = nombreModelo;
        this.colorModelo = colorModelo;
    }

    public Modelo(String nombreModelo, String colorModelo) {
        this.nombreModelo = nombreModelo;
        this.colorModelo = colorModelo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public String getColorModelo() {
        return colorModelo;
    }

    public void setColorModelo(String colorModelo) {
        this.colorModelo = colorModelo;
    }
}
