
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.fe.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SOPORTE
 */
public class lImpuestoBean {

    private String codigoTipoAfectacionIGV;
    private double montoTotalMonedaOriginal;
    private String codigoInternacional;
    private double montoBaseMonedaOriginal;
    private String nombre;
    private double porcentaje;
    private String codigo;
    private BigInteger cantidadBolsas;
    private BigDecimal valorBolsas;
//    private double montoTotalMonedaOriginalGeneral;
//    private int cantiBolsas = 0;

//    public double getMontoTotalMonedaOriginalGeneral() {
//        return montoTotalMonedaOriginalGeneral;
//    }
//
//    public void setMontoTotalMonedaOriginalGeneral(double montoTotalMonedaOriginalGeneral) {
//        this.montoTotalMonedaOriginalGeneral = montoTotalMonedaOriginalGeneral;
//    }
    
    public lImpuestoBean() {
    }

    /**
     * @return the codigoTipoAfectacionIGV
     */
    public String getCodigoTipoAfectacionIGV() {
        return codigoTipoAfectacionIGV;
    }

    /**
     * @param codigoTipoAfectacionIGV the
     * codigoTipoAfectacionIGV to set
     */
    public void setCodigoTipoAfectacionIGV(String codigoTipoAfectacionIGV) {
        this.codigoTipoAfectacionIGV = codigoTipoAfectacionIGV;
    }

    /**
     * @return the montoTotalMonedaOriginal
     */
    public double getMontoTotalMonedaOriginal() {
        return montoTotalMonedaOriginal;
    }

    /**
     * @param montoTotalMonedaOriginal the
     * montoTotalMonedaOriginal to set
     */
    public void setMontoTotalMonedaOriginal(double montoTotalMonedaOriginal) {
        this.montoTotalMonedaOriginal = montoTotalMonedaOriginal;
    }

    /**
     * @return the codigoInternacional
     */
    public String getCodigoInternacional() {
        return codigoInternacional;
    }

    /**
     * @param codigoInternacional the
     * codigoInternacional to set
     */
    public void setCodigoInternacional(String codigoInternacional) {
        this.codigoInternacional = codigoInternacional;
    }

    /**
     * @return the montoBaseMonedaOriginal
     */
    public double getMontoBaseMonedaOriginal() {
        return montoBaseMonedaOriginal;
    }

    /**
     * @param montoBaseMonedaOriginal the
     * montoBaseMonedaOriginal to set
     */
    public void setMontoBaseMonedaOriginal(double montoBaseMonedaOriginal) {
        this.montoBaseMonedaOriginal = montoBaseMonedaOriginal;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the porcentaje
     */
    public double getPorcentaje() {
        return porcentaje;
    }

    /**
     * @param porcentaje the porcentaje to set
     */
    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigInteger getCantidadBolsas() {
        return cantidadBolsas;
    }

    public void setCantidadBolsas(BigInteger cantidadBolsas) {
        this.cantidadBolsas = cantidadBolsas;
    }

    public BigDecimal getValorBolsas() {
        return valorBolsas;
    }

    public void setValorBolsas(BigDecimal valorBolsas) {
        this.valorBolsas = valorBolsas;
    }

//    public ArrayList<lImpuestoBean> getImpDocBen(List<String[]> impuesto) {
//        String[] cadena;
//        ArrayList<lImpuestoBean> listDetaImp = new ArrayList<>();
//        double impTotal = 0.0;
//        for (String[] cad : impuesto) {
//            lImpuestoBean impBean = new lImpuestoBean();
//            if (cad[0].equals("1000")){
//                impBean.setCodigoTipoAfectacionIGV("10"); 
//                impBean.setPorcentaje(18.0);
//                impBean.setMontoBaseMonedaOriginal(Double.parseDouble(cad[3]));
//            }else if (cad[0].equals("7152")){
//                impBean.setCantidadBolsas(new BigInteger(""+this.cantiBolsas));
//            }
//            
//            impBean.setMontoTotalMonedaOriginal(Double.parseDouble(cad[4]));
//            impTotal += Double.parseDouble(cad[4]);
//            impBean.setCodigo(cad[0]);
//            impBean.setNombre(cad[1]);
//            impBean.setCodigoInternacional(cad[2]);
//            
//            listDetaImp.add(impBean);
//        }
//        String decimales2 = (""+impTotal).substring(0, 4);
//        
//        //impTotal = Math.round(impTotal);
//        this.setMontoTotalMonedaOriginalGeneral(Double.parseDouble(decimales2));
//        return listDetaImp;
//    }

}
