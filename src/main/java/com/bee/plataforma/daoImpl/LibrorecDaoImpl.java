/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.daoImpl;

import com.bee.plataforma.config.conexion;
import com.bee.plataforma.dao.LibrorecDao;
import com.bee.plataforma.model.LibrorecModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RAYP
 */
@Repository
public class LibrorecDaoImpl implements LibrorecDao{
    @Override
    public int librorecregistra(LibrorecModel lib) throws Exception{
       int vals=0;
        String numcorrelativo ="";
        ResultSet rs;
        
        try{
           conexion cn = new conexion();
           String cons = "select * from sh_atworkpf.fn_librorec_registrar("+lib.getIddoc()+",'"+lib.getNumdoc()+"','"+lib.getApepat()+"','"+lib.getApemat()+"','"+lib.getNombre()+"','"+lib.getDep()+ "','"+lib.getProv()+ "','"+lib.getDist()+ "','"+ lib.getDirec()+ "','"+ lib.getTelf() +"','"+ lib.getEmail()+"',"+lib.getAreaid()+","+lib.getMotivoid()+ ","+lib.getMonto()+",'" + lib.getDescbien() + "','" + lib.getTipo()+"','" + lib.getDetalle()+"','" + lib.getPedido()+"','"+lib.getRuta_doc()+"','"+lib.getNom_doc()+"."+lib.getExt_doc()+"')" ;
           System.out.println(cons);
           rs = cn.Query(cons);
           while(rs.next()){
               numcorrelativo = rs.getString("numero");
           }
           if(numcorrelativo!="0"){
              vals=1;
           }
           lib.setResplibrorec(vals);
           lib.setCorrelativo(numcorrelativo);
           
        }catch(SQLException e){
           System.out.println(e.getMessage());
        }
        return vals;
    }
    @Override
    public String libroreccorreoenv(String emp) throws Exception{
        String vars="";
        ResultSet rs;
        try{
            conexion cn = new conexion();
            String cons="select concat(empresa_mail_supervisor,'¦',empresa_mail_call) as resp from sh_atworkpf.atworkpf_empresa where empresa_id="+emp+"";
            System.out.println("--"+cons);
            rs = cn.Query(cons);
            while(rs.next()){
               vars = rs.getString("resp");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return vars;
    
    }
    
}
