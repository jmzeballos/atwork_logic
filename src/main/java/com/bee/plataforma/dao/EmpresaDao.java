/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.dao;

import com.bee.plataforma.model.EmpresaModel;
import java.util.List;

/**
 *
 * @author Lealva
 */
public interface EmpresaDao {

    public List<EmpresaModel> listarEmpresa() throws Exception;
}
