package com.unow.vehicleManagement.service;

import com.unow.vehicleManagement.dao.IDao;
import com.unow.vehicleManagement.dao.ModeloDaoH2;
import com.unow.vehicleManagement.model.Modelo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloService {

    private IDao<Modelo> modeloIDao;

    public ModeloService() {
        this.modeloIDao = new ModeloDaoH2();
    }

    public Modelo save(Modelo modelo) {
        return modeloIDao.save(modelo);
    }

    public Modelo findById(Integer id) {
        return modeloIDao.findById(id);
    }

    public void update(Modelo modelo) {
        modeloIDao.update(modelo);
    }

    public void delete(Integer id) {
        modeloIDao.delete(id);
    }

    public List<Modelo> findAll() {
        return modeloIDao.findAll();
    }
}
