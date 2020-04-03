/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.daoImpl;

import com.bee.plataforma.config.conexion;
import com.bee.plataforma.dao.UbigeoDao;
import com.bee.plataforma.model.UbigeoModel;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lealva
 */
@Repository
public class UbigeoDaoImpl implements UbigeoDao{
    Logger logger = Logger.getLogger(UbigeoDaoImpl.class);
    @Override
    public List<UbigeoModel> listaDepartamentos() throws Exception {
    List<UbigeoModel> listaDepartamento = new ArrayList<>();
        
        try {
            conexion cn = new conexion();
            ResultSet rs =cn.Query("select * from sh_atworkpf.fn_ubigeo_departamento_listar()");
            while (rs.next()){
                UbigeoModel ubiMd= new UbigeoModel();
                ubiMd.setDepartamento_id(rs.getString("out_iddep"));
                ubiMd.setNombre(rs.getString("out_nomdep"));
                listaDepartamento.add(ubiMd);
            }
            logger.info("Departamento : " + listaDepartamento.get(0).getNombre());
            logger.info("Listado : " + listaDepartamento.size());
        } catch (Exception e) {
            logger.error(e.getMessage());
            
        }
        return listaDepartamento;}

    @Override
    public List<UbigeoModel> listaProvincia(UbigeoModel ubig) throws Exception {
         List<UbigeoModel> listaProvincia = new ArrayList<>();
        try {
            conexion cn = new conexion();
            ResultSet rs = cn.Query("select * from sh_atworkpf.fn_ubigeo_provincia_listar("+ubig.getDepartamento_id()+")");
            while (rs.next()){
                UbigeoModel ubiMd= new UbigeoModel();
                ubiMd.setDepartamento_id(rs.getString("out_iddep"));
                ubiMd.setProvincia_id(rs.getString("out_idprov"));
                ubiMd.setNombre(rs.getString("out_nomprov"));
                listaProvincia.add(ubiMd);
            }
            logger.info("Provincia DAO : " + listaProvincia.get(0).getNombre());
            logger.info("Listado DAO : " + listaProvincia.size());
        } catch (Exception e) {
            logger.error(e.getMessage());
            
        }
        return listaProvincia;}

    @Override
    public List<UbigeoModel> listaDistrito(UbigeoModel ubig) throws Exception {
     List<UbigeoModel> listaDistrito = new ArrayList<>();
        try {
            conexion cn = new conexion();
            ResultSet rs =cn.Query("select * from sh_atworkpf.fn_ubigeo_distrito_listar("+ubig.getDepartamento_id()+","+ubig.getProvincia_id()+")");
            while (rs.next()){
                UbigeoModel ubiMd= new UbigeoModel();
                ubiMd.setDistrito_id(rs.getString("out_iddist"));
                ubiMd.setNombre(rs.getString("out_nomdist"));
                listaDistrito.add(ubiMd);
            }
            logger.info("Distrito DAO : " + listaDistrito.get(0).getNombre());
            logger.info("Listado Distrito DAO : " + listaDistrito.size());
        } catch (Exception e) {
            logger.error(e.getMessage());
            
        }
        return listaDistrito;}
    
}
