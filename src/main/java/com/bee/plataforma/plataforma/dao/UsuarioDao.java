/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.dao;

import com.bee.plataforma.model.UsuarioModel;

/**
 *
 * @author Lealva
 */
public interface UsuarioDao {

    public int usuarioregistra(UsuarioModel usuario) throws Exception;

    public UsuarioModel accesoUsuario(UsuarioModel usuario) throws Exception;
}
