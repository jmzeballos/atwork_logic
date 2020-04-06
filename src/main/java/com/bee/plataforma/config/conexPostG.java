/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.config;
import java.sql.*;

public class conexPostG {

    Connection cn = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    Statement st = null;
    String conectado;

    public conexPostG() {
        try {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de PostgreSQL: " + ex.getMessage());
            }
            this.cn = DriverManager.getConnection(
                    "jdbc:postgresql://167.71.145.62:5432/servicemail",
                    "postgres", "20191016-B33@lU4");

            boolean valid = this.cn.isValid(50000);
            //System.out.println(valid ? "TEST OK TEST" : "TEST FAIL");
            this.conectado = valid ? "TEST OK TEST" : "TEST FAIL";
        } catch (java.sql.SQLException sqle) {
            //System.out.println("Error: " + sqle);
        }
    }

    public String getConectado(){
      return this.conectado;
     }
    
    public int executeUpdate( String sqlCad) {
        int res = 0;
        try {
            pst = this.cn.prepareCall(sqlCad);
            res = pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        return res;
    }

    public ResultSet Query(String query) {
        try {
            st = this.cn.createStatement();
            rs = st.executeQuery(query);
            this.cn.close();
        } catch (Exception e) {
            System.out.println( "Error en metodo : " + e.getMessage());
        }
        return rs;
    }


}
