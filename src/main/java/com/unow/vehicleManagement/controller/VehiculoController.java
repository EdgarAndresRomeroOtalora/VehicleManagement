package com.unow.vehicleManagement.controller;

import com.unow.vehicleManagement.model.Marca;
import com.unow.vehicleManagement.model.Vehiculo;
import com.unow.vehicleManagement.service.MarcaService;
import com.unow.vehicleManagement.service.VehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> save(@RequestBody Vehiculo vehiculo) {
        if(vehiculo.getMatricula().length()!=6){
            ErrorResponse errorResponse = new ErrorResponse("La matricula debe ser de 6 caracteres");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
        if(vehiculo.getAnio() < 1000 || vehiculo.getAnio() > 9999){
            ErrorResponse errorResponse = new ErrorResponse("el formato del año no es correcto");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(vehiculoService.save(vehiculo));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Vehiculo vehiculo) {
        if(vehiculo.getMatricula().length()!=6){
            ErrorResponse errorResponse = new ErrorResponse("La matricula debe ser de 6 caracteres");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
        if(vehiculo.getAnio() < 1000 || vehiculo.getAnio() > 9999){
            ErrorResponse errorResponse = new ErrorResponse("el formato del año no es correcto");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
        vehiculoService.update(vehiculo);
        return ResponseEntity.ok("Vehiculo Actualizado Correctamente");
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
