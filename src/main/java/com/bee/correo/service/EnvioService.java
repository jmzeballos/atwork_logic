/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.correo.service;

import com.bee.correo.model.EnvioModel;

/**
 *
 * @author Lealva
 */
public interface EnvioService {

    public boolean guardarCorreo(EnvioModel envio) throws Exception;
}
