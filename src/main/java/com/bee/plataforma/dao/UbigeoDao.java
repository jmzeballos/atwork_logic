/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.dao;

import com.bee.plataforma.model.UbigeoModel;
import java.util.List;

/**
 *
 * @author Lealva
 */
public interface UbigeoDao {

    public List<UbigeoModel> listaDepartamentos() throws Exception;

    public List<UbigeoModel> listaProvincia(UbigeoModel ubig) throws Exception;

    public List<UbigeoModel> listaDistrito(UbigeoModel ubig) throws Exception;
}
