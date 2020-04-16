/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.daoImpl;

import com.bee.plataforma.config.EncryptDecryptUtil;
import com.bee.plataforma.config.conexion;
import com.bee.plataforma.dao.EmpresaDao;
import com.bee.plataforma.model.EmpresaModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lealva
 */
@Repository
public class EmpresaDaoImpl implements EmpresaDao {

    Logger logger = Logger.getLogger(EmpresaDaoImpl.class);

    @Override
    public List<EmpresaModel> listarEmpresa() throws Exception {
        List<EmpresaModel> listaEmpresa = new ArrayList<>();
        try {
            conexion cn = new conexion();
            String query = "select * from sh_atworkpf.fn_empresa_listar_v2()";
            logger.error(query);
            ResultSet rs = cn.Query(query);
            System.out.println("Query: " + query);
            while (rs.next()) {
                EmpresaModel empresa = new EmpresaModel();
                empresa.setEmpresa_id(rs.getInt("out_empid"));
                empresa.setNombre(rs.getString("out_empnom"));
                empresa.setEstado(rs.getInt("resp"));
                listaEmpresa.add(empresa);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return listaEmpresa;

    }

    @Override
    public List<EmpresaModel> buscarEmpresa(String empresa) throws Exception {
        List<EmpresaModel> listaEmpresa = new ArrayList<>();
        try {
            conexion cn = new conexion();
            String query = "select * from sh_atworkpf.fn_empresa_listar_v3('" + empresa + "')";
            logger.error(query);
            ResultSet rs = cn.Query(query);
            System.out.println("Query: " + query);
            while (rs.next()) {
                EmpresaModel emp = new EmpresaModel();
                emp.setEmpresa_id(rs.getInt("out_empid"));
                emp.setNombre(rs.getString("out_empnom"));
                emp.setEstado(rs.getInt("resp"));
                listaEmpresa.add(emp);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return listaEmpresa;
    }

}
