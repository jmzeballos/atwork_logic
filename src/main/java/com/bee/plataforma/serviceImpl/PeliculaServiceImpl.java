/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.serviceImpl;

import com.bee.plataforma.dao.PeliculaDao;
import com.bee.plataforma.model.PeliculaModel;
import com.bee.plataforma.service.PeliculaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lealva
 */
@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    private PeliculaDao peliDao;

    @Override
    public List<PeliculaModel> PeliculaListar() throws Exception {
        return peliDao.PeliculaListar();
    }

}
