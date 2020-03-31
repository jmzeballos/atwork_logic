/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.serviceImpl;

import com.bee.plataforma.dao.EmpresaDao;
import com.bee.plataforma.model.EmpresaModel;
import com.bee.plataforma.service.EmpresaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lealva
 */
@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaDao empresaDao;

    @Override
    public List<EmpresaModel> listarEmpresa() throws Exception {
        return empresaDao.listarEmpresa();
    }

}
