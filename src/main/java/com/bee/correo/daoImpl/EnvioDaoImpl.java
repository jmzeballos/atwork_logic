/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.correo.daoImpl;

import com.bee.correo.dao.EnvioDao;
import com.bee.correo.model.EnvioModel;
import com.bee.plataforma.config.conexPostG;
import com.bee.plataforma.config.conexion;
import java.sql.ResultSet;
import org.apache.log4j.Logger;

/**
 *
 * @author Lealva
 */
public class EnvioDaoImpl implements EnvioDao {
    Logger logger = Logger.getLogger(EnvioDaoImpl.class);
    @Override
    public boolean guardarCorreo(EnvioModel envio) throws Exception {
        boolean respuesta = false;
        try {
            conexPostG cn = new conexPostG();
            String query = "select * from sh_mails.fn_insert_email('" + envio.getEmail()+"',"+envio.getCanalenvio()+",'"+envio.getAdjuntoname()+"','"+envio.getAdjunto64()+"','"+envio.getObs()+"','"+envio.getKey()+ "')";
  
            System.out.println("Query " + query);
            ResultSet rs = cn.Query(query);
            while (rs.next()) {
                respuesta = rs.getBoolean("respuesta");

            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return respuesta;
    }

}
