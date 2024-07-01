package com.unow.vehicleManagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {

    private static final String DRIVER = "org.h2.Driver";

    private static final String URL = "jdbc:h2:./dc";

    private static final String USER = "sa";

    private static final String PASSWORD = "sa";

    private static final String SQL_DROP_CREATE_MODELOS = " DROP TABLE IF EXISTS " +
            "MODELOS; CREATE TABLE MODELOS (ID INT AUTO_INCREMENT PRIMARY KEY, " +
            "NOMBRE_MODELO VARCHAR(100) NOT NULL, " +
            "COLOR_MODELO VARCHAR(100) NOT NULL)";

    private static final String SQL_DROP_CREATE_MARCAS = " DROP TABLE IF EXISTS " +
            "MARCAS; CREATE TABLE MARCAS (ID INT AUTO_INCREMENT PRIMARY KEY, " +
            "NOMBRE_MARCA VARCHAR(100) NOT NULL, " +
            "MODELO_ID INT NOT NULL)";

    private static final String SQL_DROP_CREATE_VEHICULOS = " DROP TABLE IF EXISTS " +
            "VEHICULOS; CREATE TABLE VEHICULOS (ID INT AUTO_INCREMENT PRIMARY KEY, " +
            "MARCA_ID INT NOT NULL, " +
            "MATRICULA VARCHAR(6) NOT NULL, " +
            "ANIO INT NOT NULL)";

    private static final String SQL_INSERT = "INSERT INTO MODELOS(NOMBRE_MODELO, COLOR_MODELO" +
            ") VALUES ('Sail', 'rojo');";

    public static Connection getConnection() throws Exception{
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    };

    public static void createTables(){
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_DROP_CREATE_MODELOS);
            statement.execute(SQL_DROP_CREATE_MARCAS);
            statement.execute(SQL_DROP_CREATE_VEHICULOS);
            statement.execute(SQL_INSERT);

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
