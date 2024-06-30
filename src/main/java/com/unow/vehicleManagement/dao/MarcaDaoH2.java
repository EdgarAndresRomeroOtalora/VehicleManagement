package com.unow.vehicleManagement.dao;

import com.unow.vehicleManagement.model.Marca;
import com.unow.vehicleManagement.model.Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarcaDaoH2 implements IDao<Marca> {

    private static final String SQL_INSERT = "INSERT INTO MARCAS (NOMBRE_MODELO, COLOR_MODELO) VALUES(?,?)";

    private static final String SQL_SELECT_ID = "SELECT * FROM MARCAS WHERE ID = ?";

    private static final String SQL_UPDATE = "UPDATE MARCAS SET NOMBRE_MARCA=?, MODELO_ID=? WHERE ID = ?";

    private static final String SQL_DELETE = "DELETE FROM MARCAS WHERE ID = ?";

    private static final String SQL_SELECT_ALL = "SELECT * FROM MARCAS";


    @Override
    public Marca save(Marca marca) {
        Connection connection = null;
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, marca.getNombreMarca());
            ps.setInt(2, marca.getModelo().getId());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                marca.setId(rs.getInt(1));
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        return marca;
    }

    @Override
    public Marca findById(Integer id) {
        Connection connection = null;
        Marca marca = null;
        try {
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ID);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            ModeloDaoH2 modeloDaoH2 = new ModeloDaoH2();

            while (rs.next()) {
                Modelo modelo = modeloDaoH2.findById(rs.getInt(3));
                marca = new Marca(rs.getInt(1), rs.getString(2), modelo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        return marca;
    }

    @Override
    public void update(Marca marca) {
        Connection connection = null;
        try {
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE);
            ps.setString(1, marca.getNombreMarca());
            ps.setInt(2, marca.getModelo().getId());
            ps.setInt(3, marca.getId());
            ps.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Integer id) {
        Connection connection = null;
        try {
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_DELETE);
            ps.setInt(1, id);
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Marca> findAll() {
        Connection connection = null;
        Modelo modelo;
        List<Marca> marcas = new ArrayList<>();
        try {
            ModeloDaoH2 modeloDaoH2 = new ModeloDaoH2();
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                modelo = modeloDaoH2.findById(rs.getInt(6));
                marcas.add(new Marca(rs.getInt(1), rs.getString(2),
                        modelo));
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        return marcas;
    }
}
