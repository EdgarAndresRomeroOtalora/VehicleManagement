package com.unow.vehicleManagement.service;

import com.unow.vehicleManagement.dao.IDao;
import com.unow.vehicleManagement.dao.MarcaDaoH2;
import com.unow.vehicleManagement.dao.VehiculoDaoH2;
import com.unow.vehicleManagement.model.Marca;
import com.unow.vehicleManagement.model.Vehiculo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {

    private IDao<Vehiculo> vehiculoIDao;

    public VehiculoService() {
        this.vehiculoIDao = new VehiculoDaoH2();
    }

    public Vehiculo save(Vehiculo vehiculo) {
        return vehiculoIDao.save(vehiculo);
    }

    public Vehiculo findById(Integer id) {
        return vehiculoIDao.findById(id);
    }

    public void update(Vehiculo vehiculo) {
        vehiculoIDao.update(vehiculo);
    }

    public void delete(Integer id) {
        vehiculoIDao.delete(id);
    }

    public List<Vehiculo> findAll() {
        return vehiculoIDao.findAll();
    }
}
