/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.serviceImpl;

import com.bee.plataforma.dao.UbigeoDao;
import com.bee.plataforma.model.UbigeoModel;
import com.bee.plataforma.service.UbigeoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Lealva
 */
@Service
public class UbigeoServiceImpl implements UbigeoService{
    @Autowired
    private UbigeoDao ubiDao;
    
    @Override
    public List<UbigeoModel> listaDepartamentos() throws Exception {
      return  ubiDao.listaDepartamentos();
    }

    @Override
    public List<UbigeoModel> listaProvincia(UbigeoModel ubig) throws Exception {
        return ubiDao.listaProvincia(ubig);
    }

    @Override
    public List<UbigeoModel> listaDistrito(UbigeoModel ubig) throws Exception {
        return ubiDao.listaDistrito(ubig);
    }
    
}
