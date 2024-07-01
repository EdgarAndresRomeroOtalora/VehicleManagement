package com.unow.vehicleManagement.controller;

import com.unow.vehicleManagement.model.Marca;
import com.unow.vehicleManagement.model.Vehiculo;
import com.unow.vehicleManagement.service.MarcaService;
import com.unow.vehicleManagement.service.VehiculoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    private VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping("/{id}")
    public Vehiculo findById(@PathVariable Integer id) {
        return vehiculoService.findById(id);
    }

    @PostMapping
    public Vehiculo save(@RequestBody Vehiculo vehiculo) {
        return vehiculoService.save(vehiculo);
    }

    @PutMapping
    public void update(@RequestBody Vehiculo vehiculo) {
        vehiculoService.update(vehiculo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        vehiculoService.delete(id);
    }

    @GetMapping
    public List<Vehiculo> findAll() {
        return vehiculoService.findAll();
    }
}
