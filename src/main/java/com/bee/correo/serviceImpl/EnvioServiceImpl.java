/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.correo.serviceImpl;

import com.bee.correo.dao.EnvioDao;
import com.bee.correo.model.EnvioModel;
import com.bee.correo.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lealva
 */
@Service
public class EnvioServiceImpl implements EnvioService {

    @Autowired
    private EnvioDao envioDao;

    @Override
    public boolean guardarCorreo(EnvioModel envio) throws Exception {
        return envioDao.guardarCorreo(envio);
    }

}
