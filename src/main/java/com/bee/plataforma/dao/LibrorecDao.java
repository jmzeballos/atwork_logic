/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.dao;

import com.bee.plataforma.model.LibrorecModel;

/**
 *
 * @author RAYP
 */
public interface LibrorecDao {
     public int librorecregistra(LibrorecModel lib) throws Exception;
     public String libroreccorreoenv(String emp) throws Exception;
}
