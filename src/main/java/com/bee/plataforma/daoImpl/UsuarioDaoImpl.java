/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.daoImpl;

import com.bee.plataforma.config.EncryptDecryptUtil;
import com.bee.plataforma.config.conexion;
import com.bee.plataforma.dao.UsuarioDao;
import com.bee.plataforma.model.UsuarioModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lealva
 */
@Repository
public class UsuarioDaoImpl implements UsuarioDao {

    Logger logger = Logger.getLogger(UsuarioDaoImpl.class);

    @Override
    public int usuarioregistra(UsuarioModel usuario) throws Exception {
        int respuesta = 3;
        try {
            conexion cn = new conexion();
            String value = usuario.getDni();
            value = EncryptDecryptUtil.encryptPhrase(value);
            usuario.setPassword(value);
            String empresaEncryp = (usuario.getPasswordEmpresa().equals("") ? "" : EncryptDecryptUtil.encryptPhrase(usuario.getPasswordEmpresa()));
            String query = "select * from sh_atworkpf.fn_usuario_registrar_v2('" + usuario.getNombre() + "','" + usuario.getApellido() + "','" + usuario.getCorreo() + "','" + usuario.getDni() + "','" + usuario.getPassword() + "'," + usuario.getEmpresa_id() + ",'" + usuario.getPasswordEmpresa() + "','" + empresaEncryp + "')";
            logger.error(query);

            System.out.println("Query " + query);
            ResultSet rs = cn.Query(query);

            while (rs.next()) {
                respuesta = rs.getInt("out_resp");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return respuesta;
    }

    @Override
    public UsuarioModel accesoUsuario(UsuarioModel usuario) throws Exception {
        try {
            conexion cn = new conexion();
            String value = usuario.getPassword();
            value = EncryptDecryptUtil.encryptPhrase(value);
            usuario.setPassword(value);
            System.out.println("iNGRESP: " + usuario.getPasswordEmpresa());
            String empresaEncryp = "";
            if (usuario.getPasswordEmpresa() != null) {

                empresaEncryp = (usuario.getPasswordEmpresa().equals("") ? "" : EncryptDecryptUtil.encryptPhrase(usuario.getPasswordEmpresa()));
            } else {
                usuario.setPasswordEmpresa((usuario.getPasswordEmpresa() != null ? usuario.getPasswordEmpresa() : ""));
            }

            String query = "select * from sh_atworkpf.fn_usuario_login_v8('" + usuario.getUsuario() + "','" + usuario.getPassword() + "','" + usuario.getPasswordEmpresa() + "','" + empresaEncryp + "')";

            System.out.println(query);
            ResultSet rs = cn.Query(query);
            while (rs.next()) {
                usuario.setRespuesta(rs.getInt("out_resp"));
                usuario.setUsuario_id(rs.getInt("out_idcli"));
                usuario.setEmpresa_id(rs.getInt("out_idemp"));
                usuario.setCorreo(rs.getString("out_email"));
                usuario.setNombre(rs.getString("out_nombre"));
                usuario.setApellido(rs.getString("out_apellidos"));
                usuario.setDni(rs.getString("out_dni"));
                usuario.setVenta_id(rs.getInt("out_idventa"));
                usuario.setCodigo_disponible(rs.getInt("out_coddis"));
                System.out.println("Respuesta : " + rs.getString("out_coddis"));
                usuario.setLogo_empresa(rs.getString("out_img64"));
                usuario.setContenido(rs.getString("out_resp2"));
                usuario.setDetalle_venta(rs.getString("out_detalleve"));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        System.out.println("Id: " + usuario.getNombre());
        return usuario;
    }

}
