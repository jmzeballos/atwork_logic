/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.config;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;

/**
 *
 * @author Lealva
 */
public class conexion {
  
    ResultSet rs = null;
    CallableStatement cs = null;
    Connection cn = null;
    Logger logger = Logger.getLogger(conexion.class);
    Statement st = null;
    
    public conexion() {
        try {
            try {
              
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
            }
            cn =
                    DriverManager.getConnection(
                    "jdbc:postgresql://167.71.145.62:5432/CINE_DESARROLLO",
                    "postgres", "20191016-B33@lU4");
            System.out.println("Successful connection Local");

        } catch (SQLException e) {
            logger.error("Error de conexion : " + e.getMessage());
            e.printStackTrace();
        }
    }


    public void cerrarConexion() {
        try {
            this.cn.close();
        } catch (Exception e) {
        }
    }
    
    public ResultSet Query(String query) throws SQLException {
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);
            cn.close();
        } catch (Exception e) {
            System.out.println("Error en metodo : " + e.getMessage());
        }finally{
            cn.close();
        }
        return rs;
    }  
}
