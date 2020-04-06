/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.daoImpl;

import com.bee.plataforma.config.EncryptDecryptUtil;
import com.bee.plataforma.config.EnvioMail;
import com.bee.plataforma.config.conexion;
import com.bee.plataforma.correo.CuerpoEnvioRecPassword;
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

            String query = "select * from sh_atworkpf.fn_usuario_login_v9('" + usuario.getUsuario() + "','" + usuario.getPassword() + "','" + usuario.getPasswordEmpresa() + "','" + empresaEncryp + "')";

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
                usuario.setFecha_actual(rs.getString("out_fechaactual"));
                usuario.setFecha_venta(rs.getString("out_fechaven"));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        System.out.println("Id: " + usuario.getNombre());
        return usuario;
    }

    @Override
    public int usuarioactualiza(UsuarioModel usuario) throws Exception {
        int respuesta = 0;
        try {
            conexion cn = new conexion();
            String query = "select * from sh_atworkpf.fn_usuario_editar_v2(" + usuario.getUsuario_id() + ",'" + usuario.getCorreo() + "','" + usuario.getCelular()
                    + "','" + usuario.getFechaNacimiento() + "'," + usuario.getDepartamento_id() + ","
                    + usuario.getProvincia_id() + "," + usuario.getDistrito_id() + ",'" + usuario.getSexo() + "')";
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
    public int verificarrecuperacontraseña(UsuarioModel usuario) throws Exception {
        try {
            conexion cn = new conexion();
            String query = "select * from sh_atworkpf.fn_usuario_recuperar_clave('" + usuario.getCorreo() + "')";
            logger.error(query);

            System.out.println("Query " + query);
            ResultSet rs = cn.Query(query);
            while (rs.next()) {
                usuario.setRespuesta(rs.getInt("out_resp"));
                usuario.setUsuario_id(rs.getInt("out_idusu"));
                usuario.setNombre(rs.getString("out_nombre"));
                usuario.setApellido(rs.getString("out_apellido"));
            }
            if (usuario.getRespuesta() == 1) {
                EnvioMail envio = new EnvioMail();
                envio.sendMail("atencionalcliente@bee.com.pe", usuario.getCorreo(), "Cambio de Contraseña Cineplanet Atwork", new CuerpoEnvioRecPassword().cuerpoEnvio(String.valueOf(usuario.getUsuario_id()), usuario.getNombre() + " " + usuario.getApellido()));
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return usuario.getRespuesta();
    }

    @Override
    public int actualizarcontraseña(UsuarioModel usuario) throws Exception {
        int respuesta = 0;
        try {
            conexion cn = new conexion();
            String value = EncryptDecryptUtil.encryptPhrase(usuario.getPassword());
            String query = "select * from sh_atworkpf.fn_usuario_actualizar_clave(" + usuario.getUsuario_id() + ",'" + value + "')";
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
    public UsuarioModel usuarioperfil(UsuarioModel usuario) throws Exception {
        try {
            conexion cn = new conexion();
            String query = "select * from sh_atworkpf.fn_usuario_listar(" + usuario.getUsuario_id() + ")";
            logger.error(query);

            System.out.println("Query " + query);
            ResultSet rs = cn.Query(query);
            while (rs.next()) {
                usuario.setRespuesta(rs.getInt("out_resp"));
                usuario.setCorreo(rs.getString("out_email"));
                usuario.setNombreEmpresa(rs.getString("out_emp"));
                usuario.setCelular(rs.getString("out_celu"));
                usuario.setFechaNacimiento(rs.getString("out_fechanac"));
                usuario.setSexo(rs.getString("out_sexo"));
                usuario.setDepartamento_id(rs.getInt("out_dep"));
                usuario.setProvincia_id(rs.getInt("out_prov"));
                usuario.setDistrito_id(rs.getInt("out_dist"));
                usuario.setNombre(rs.getString("out_nom"));
                usuario.setApellido(rs.getString("out_ape"));
                usuario.setDni(rs.getString("out_dni")); 
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return usuario;
    }

}
