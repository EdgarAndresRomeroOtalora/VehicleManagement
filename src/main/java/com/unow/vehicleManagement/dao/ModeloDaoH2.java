package com.unow.vehicleManagement.dao;

import com.unow.vehicleManagement.model.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ModeloDaoH2 implements IDao<Modelo>{

    private static final String SQL_INSERT = "INSERT INTO MODELOS (NOMBRE_MODELO, COLOR_MODELO) VALUES(?,?)";

    private static final String SQL_SELECT_ID = "SELECT * FROM MODELOS WHERE ID = ?";

    private static final String SQL_UPDATE = "UPDATE MODELOS SET NOMBRE_MODELO=?, COLOR_MODELO=? WHERE ID = ?";

    private static final String SQL_DELETE = "DELETE FROM MODELOS WHERE ID = ?";

    private static final String SQL_SELECT_ALL = "SELECT * FROM MODELOS";

    @Override
    public Modelo save(Modelo modelo) {
        Connection connection = null;
        try {
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, modelo.getNombreModelo());
            ps.setString(2, modelo.getColorModelo());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                modelo.setId(rs.getInt(1));
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

        return modelo;
    }

    @Override
    public Modelo findById(Integer id) {
        Connection connection = null;
        Modelo modelo = null;
        try {
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ID);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                modelo = new Modelo(rs.getInt(1), rs.getString(2), rs.getString(3));
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

        return modelo;
    }

    @Override
    public void update(Modelo modelo) {
        Connection connection = null;
        try {
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE);
            ps.setString(1, modelo.getNombreModelo());
            ps.setString(2, modelo.getColorModelo());
            ps.setInt(3, modelo.getId());
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
    public List<Modelo> findAll() {
        Connection connection = null;
        Modelo modelo = null;
        List<Modelo> modelos = new ArrayList<>();
        try {
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                modelo = new Modelo(rs.getInt(1), rs.getString(2), rs.getString(3));
                modelos.add(modelo);
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
        return modelos;
    }
}
