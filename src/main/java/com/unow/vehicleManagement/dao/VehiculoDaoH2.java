package com.unow.vehicleManagement.dao;

import com.unow.vehicleManagement.model.Marca;
import com.unow.vehicleManagement.model.Vehiculo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDaoH2 implements IDao<Vehiculo>{

    private static final String SQL_INSERT = "INSERT INTO VEHICULOS (MARCA_ID, MATRICULA, ANIO) VALUES(?,?,?)";

    private static final String SQL_SELECT_ID = "SELECT * FROM VEHICULOS WHERE ID = ?";

    private static final String SQL_UPDATE = "UPDATE VEHICULOS SET MARCA_ID=?, MATRICULA=?, ANIO=? WHERE ID = ?";

    private static final String SQL_DELETE = "DELETE FROM VEHICULOS WHERE ID = ?";

    private static final String SQL_SELECT_ALL = "SELECT * FROM VEHICULOS";

    @Override
    public Vehiculo save(Vehiculo vehiculo) {
        Connection connection = null;
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, vehiculo.getMarca().getId());
            ps.setString(2, vehiculo.getMatricula());
            ps.setDate(3, Date.valueOf(vehiculo.getAnio()));
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                vehiculo.setId(rs.getInt(1));
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

        return vehiculo;
    }

    @Override
    public Vehiculo findById(Integer id) {
        Connection connection = null;
        Vehiculo vehiculo = null;
        try {
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ID);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            MarcaDaoH2 marcaDaoH2 = new MarcaDaoH2();

            while (rs.next()) {
                Marca marca = marcaDaoH2.findById(rs.getInt(2));

                vehiculo = new Vehiculo(marca, rs.getString(2), rs.getDate(3).toLocalDate());
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

        return vehiculo;
    }

    @Override
    public void update(Vehiculo vehiculo) {
        Connection connection = null;
        try {
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE);
            ps.setInt(1, vehiculo.getMarca().getId());
            ps.setString(2, vehiculo.getMatricula());
            ps.setDate(3, Date.valueOf(vehiculo.getAnio()));
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
    public List<Vehiculo> findAll() {
        Connection connection = null;
        Marca marca;
        List<Vehiculo> vehiculos = new ArrayList<>();
        try {
            MarcaDaoH2 marcaDaoH2 = new MarcaDaoH2();
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                marca = marcaDaoH2.findById(rs.getInt(2));
                vehiculos.add(new Vehiculo(rs.getInt(1), marca,
                        rs.getString(3), rs.getDate(4).toLocalDate()));
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

        return vehiculos;
    }
}
