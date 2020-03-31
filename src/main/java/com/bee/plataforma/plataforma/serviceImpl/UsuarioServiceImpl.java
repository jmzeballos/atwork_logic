/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.serviceImpl;

import com.bee.plataforma.dao.UsuarioDao;
import com.bee.plataforma.model.UsuarioModel;
import com.bee.plataforma.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lealva
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioDao usuarioDao;
    @Override
    public int usuarioregistra(UsuarioModel usuario) throws Exception {
        return usuarioDao.usuarioregistra(usuario);
    }

    @Override
    public UsuarioModel accesoUsuario(UsuarioModel usuario) throws Exception {
    return usuarioDao.accesoUsuario(usuario);
    }
    
}
