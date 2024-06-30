package com.unow.vehicleManagement.model;

import java.time.LocalDate;

public class Vehiculo {

    private Integer id;

    private Marca marca;

    private String matricula;

    private LocalDate anio;

    public Vehiculo() {
    }

    public Vehiculo(Integer id, Marca marca, String matricula, LocalDate anio) {
        this.id = id;
        this.marca = marca;
        this.matricula = matricula;
        this.anio = anio;
    }

    public Vehiculo(Marca marca, String matricula, LocalDate anio) {
        this.marca = marca;
        this.matricula = matricula;
        this.anio = anio;
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

    public LocalDate getAnio() {
        return anio;
    }

    public void setAnio(LocalDate anio) {
        this.anio = anio;
    }
}
