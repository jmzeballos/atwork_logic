/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.serviceImpl;

import com.bee.plataforma.model.LibrorecModel;
import com.bee.plataforma.service.LibrorecService;
import com.bee.plataforma.dao.LibrorecDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RAYP
 */
@Service
public class LibrorecServiceImpl implements LibrorecService {

    @Autowired
    private LibrorecDao libdao;

    @Override
    public int librorecregistra(LibrorecModel lib) throws Exception{
        return libdao.librorecregistra(lib);
    }
    
    @Override
    public String libroreccorreoenv(String emp) throws Exception{
        return libdao.libroreccorreoenv(emp);
    }
     
}
