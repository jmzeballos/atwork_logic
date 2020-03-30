/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.service;

import com.bee.plataforma.model.UsuarioModel;

/**
 *
 * @author Lealva
 */
public interface UsuarioService {
    public int usuarioregistra(UsuarioModel usuario) throws Exception;

    public UsuarioModel accesoUsuario(UsuarioModel usuario) throws Exception;
}
