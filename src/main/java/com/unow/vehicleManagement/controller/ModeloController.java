package com.unow.vehicleManagement.controller;

import com.unow.vehicleManagement.model.Modelo;
import com.unow.vehicleManagement.service.ModeloService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modelos")
public class ModeloController {

    private ModeloService modeloService;

    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @GetMapping("/{id}")
    public Modelo findById(@PathVariable Integer id) {
        return modeloService.findById(id);
    }

    @PostMapping
    public Modelo save(@RequestBody Modelo modelo) {
        return modeloService.save(modelo);
    }

    @PutMapping
    public void update(@RequestBody Modelo modelo) {
        modeloService.update(modelo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        modeloService.delete(id);
    }

    @GetMapping
    public List<Modelo> findAll() {
        return modeloService.findAll();
    }
}
