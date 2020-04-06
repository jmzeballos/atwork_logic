/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.pdf.model;

/**
 *
 * @author Lealva
 */
public class CodigoCanjeModel {
    private int codigoproducto;
    private String codigocanje;
    private String fechafinal;
    
    

    public CodigoCanjeModel() {
    }

    public String getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(String fechafinal) {
        this.fechafinal = fechafinal;
    }
    
    public int getCodigoproducto() {
        return codigoproducto;
    }

    public void setCodigoproducto(int codigoproducto) {
        this.codigoproducto = codigoproducto;
    }

    public String getCodigocanje() {
        return codigocanje;
    }

    public void setCodigocanje(String codigocanje) {
        this.codigocanje = codigocanje;
    }
    
}
