package com.unow.vehicleManagement.model;

import java.time.LocalDate;

public class Vehiculo {

    private Integer id;

    private Marca marca;

    private String matricula;

    private LocalDate año;

    public Vehiculo() {
    }

    public Vehiculo(Integer id, Marca marca, String matricula, LocalDate año) {
        this.id = id;
        this.marca = marca;
        this.matricula = matricula;
        this.año = año;
    }

    public Vehiculo(Marca marca, String matricula, LocalDate año) {
        this.marca = marca;
        this.matricula = matricula;
        this.año = año;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getAño() {
        return año;
    }

    public void setAño(LocalDate año) {
        this.año = año;
    }
}
