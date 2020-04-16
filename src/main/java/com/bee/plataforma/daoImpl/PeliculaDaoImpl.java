/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.daoImpl;

import com.bee.plataforma.config.conexion;
import com.bee.plataforma.dao.PeliculaDao;
import com.bee.plataforma.model.PeliculaModel;
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
public class PeliculaDaoImpl implements PeliculaDao{
    Logger logger = Logger.getLogger(PeliculaDaoImpl.class);
    @Override
    public List<PeliculaModel> PeliculaListar() throws Exception {
      List<PeliculaModel> listaPelicula = new ArrayList<>();
        
        try {
            conexion cn = new conexion();
            ResultSet rs =cn.Query("select * from sh_atworkpf.fn_movie_listar_v1()");
            while (rs.next()){
                PeliculaModel peli= new PeliculaModel();
                peli.setNombre(rs.getString("out_trailer"));
                peli.setImagen(rs.getString("out_name"));
                peli.setPelicula_id(rs.getInt("out_id"));
                listaPelicula.add(peli);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            
        }
        return listaPelicula; }
    
}
