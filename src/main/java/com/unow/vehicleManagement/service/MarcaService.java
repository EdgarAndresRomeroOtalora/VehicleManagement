package com.unow.vehicleManagement.service;

import com.unow.vehicleManagement.dao.IDao;
import com.unow.vehicleManagement.dao.MarcaDaoH2;
import com.unow.vehicleManagement.dao.ModeloDaoH2;
import com.unow.vehicleManagement.model.Marca;
import com.unow.vehicleManagement.model.Modelo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {

    private IDao<Marca> marcaIDao;

    public MarcaService() {
        this.marcaIDao = new MarcaDaoH2();
    }

    public Marca save(Marca marca) {
        return marcaIDao.save(marca);
    }

    public Marca findById(Integer id) {
        return marcaIDao.findById(id);
    }

    public void update(Marca marca) {
        marcaIDao.update(marca);
    }

    public void delete(Integer id) {
        marcaIDao.delete(id);
    }

    public List<Marca> findAll() {
        return marcaIDao.findAll();
    }
}
