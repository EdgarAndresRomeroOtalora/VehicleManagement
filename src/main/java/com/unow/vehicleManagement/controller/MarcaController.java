package com.unow.vehicleManagement.controller;

import com.unow.vehicleManagement.model.Marca;
import com.unow.vehicleManagement.model.Modelo;
import com.unow.vehicleManagement.service.MarcaService;
import com.unow.vehicleManagement.service.ModeloService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    private MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping("/{id}")
    public Marca findById(@PathVariable Integer id) {
        return marcaService.findById(id);
    }

    @PostMapping
    public Marca save(@RequestBody Marca marca) {
        return marcaService.save(marca);
    }

    @PutMapping
    public void update(@RequestBody Marca marca) {
        marcaService.update(marca);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        marcaService.delete(id);
    }

    @GetMapping
    public List<Marca> findAll() {
        return marcaService.findAll();
    }
}
