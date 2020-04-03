/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.fe.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author j.Zeballos
 */
public class lDetalleDocVentaBean {

    private String oDocVenta;    
    private oProductoBean oProducto;
    private ArrayList<lImpuestoBean> lImpuesto;
    private String lPropiedadItemAdicional;
//    private double montoDescuentoItemMonedaOriginal;
    private double montoValorVentaUnitarioMonedaOriginal;
    private double montoValorVentaTotalMonedaOriginal;
    private double montoPrecioVentaUnitarioMonedaOriginal;
    private double montoTotalMonedaOriginal;
    private int numeroOrden;
    private double cantidad;
//    private int cantiBolsas = 0;
//    private double montoValorReferencialUnitarioMonedaOriginal;
//    private double montoBaseDescuentoItemMonedaOriginal;
//    private double porcentajeDescuentoItem;
    
    private lDetalleDocVentaBean detaDocBen;
    
    public lDetalleDocVentaBean() {
        
    }
// Map<String, Object> datosEnv = new HashMap();
    /**
     * @return the oFactura
     */
    public String getoDocVenta() {
        return oDocVenta;
    }

    /**
     * @param oFactura the oFactura to set
     */
    public void setoDocVenta(String oFactura) {
        this.oDocVenta = oFactura;
    }

    /**
     * @return the oProducto
     */
    public oProductoBean getoProducto() {
        return oProducto;
    }

    /**
     * @param oProducto the oProducto to set
     */
    public void setoProducto(oProductoBean oProducto) {
        this.oProducto = oProducto;
    }

    /**
     * @return the lImpuesto
     */
    public ArrayList<lImpuestoBean> getlImpuesto() {
        return this.lImpuesto;
    }

    /**
     * @param lImpuesto the lImpuesto to set
     */
    public void setlImpuesto(ArrayList<lImpuestoBean> lImpuesto) {
        this.lImpuesto = lImpuesto;
    }

    /**
     * @return the lPropiedadItemAdicional
     */
    public String getlPropiedadItemAdicional() {
        return lPropiedadItemAdicional;
    }

    /**
     * @param lPropiedadItemAdicional the lPropiedadItemAdicional to set
     */
    public void setlPropiedadItemAdicional(String lPropiedadItemAdicional) {
        this.lPropiedadItemAdicional = lPropiedadItemAdicional;
    }

    /**
     * @return the montoDescuentoItemMonedaOriginal
     */
//    public double getMontoDescuentoItemMonedaOriginal() {
//        return montoDescuentoItemMonedaOriginal;
//    }
//
//    /**
//     * @param montoDescuentoItemMonedaOriginal the montoDescuentoItemMonedaOriginal to set
//     */
//    public void setMontoDescuentoItemMonedaOriginal(double montoDescuentoItemMonedaOriginal) {
//        this.montoDescuentoItemMonedaOriginal = montoDescuentoItemMonedaOriginal;
//    }

    /**
     * @return the montoValorVentaUnitarioMonedaOriginal
     */
    public double getMontoValorVentaUnitarioMonedaOriginal() {
        return montoValorVentaUnitarioMonedaOriginal;
    }

    /**
     * @param montoValorVentaUnitarioMonedaOriginal the montoValorVentaUnitarioMonedaOriginal to set
     */
    public void setMontoValorVentaUnitarioMonedaOriginal(double montoValorVentaUnitarioMonedaOriginal) {
        this.montoValorVentaUnitarioMonedaOriginal = montoValorVentaUnitarioMonedaOriginal;
    }

    /**
     * @return the montoValorVentaTotalMonedaOriginal
     */
    public double getMontoValorVentaTotalMonedaOriginal() {
        return montoValorVentaTotalMonedaOriginal;
    }

    /**
     * @param montoValorVentaTotalMonedaOriginal the montoValorVentaTotalMonedaOriginal to set
     */
    public void setMontoValorVentaTotalMonedaOriginal(double montoValorVentaTotalMonedaOriginal) {
        this.montoValorVentaTotalMonedaOriginal = montoValorVentaTotalMonedaOriginal;
    }

    /**
     * @return the montoPrecioVentaUnitarioMonedaOriginal
     */
    public double getMontoPrecioVentaUnitarioMonedaOriginal() {
        return montoPrecioVentaUnitarioMonedaOriginal;
    }

    /**
     * @param montoPrecioVentaUnitarioMonedaOriginal the montoPrecioVentaUnitarioMonedaOriginal to set
     */
    public void setMontoPrecioVentaUnitarioMonedaOriginal(double montoPrecioVentaUnitarioMonedaOriginal) {
        this.montoPrecioVentaUnitarioMonedaOriginal = montoPrecioVentaUnitarioMonedaOriginal;
    }

    /**
     * @return the montoTotalMonedaOriginal
     */
    public double getMontoTotalMonedaOriginal() {
        return montoTotalMonedaOriginal;
    }

    /**
     * @param montoTotalMonedaOriginal the montoTotalMonedaOriginal to set
     */
    public void setMontoTotalMonedaOriginal(double montoTotalMonedaOriginal) {
        this.montoTotalMonedaOriginal = montoTotalMonedaOriginal;
    }

    /**
     * @return the numeroOrden
     */
    public int getNumeroOrden() {
        return numeroOrden;
    }

    /**
     * @param numeroOrden the numeroOrden to set
     */
    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    /**
     * @return the cantidad
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

//    /**
//     * @return the montoValorReferencialUnitarioMonedaOriginal
//     */
//    public double getMontoValorReferencialUnitarioMonedaOriginal() {
//        return montoValorReferencialUnitarioMonedaOriginal;
//    }
//
//    /**
//     * @param montoValorReferencialUnitarioMonedaOriginal the montoValorReferencialUnitarioMonedaOriginal to set
//     */
//    public void setMontoValorReferencialUnitarioMonedaOriginal(double montoValorReferencialUnitarioMonedaOriginal) {
//        this.montoValorReferencialUnitarioMonedaOriginal = montoValorReferencialUnitarioMonedaOriginal;
//    }

//    /**
//     * @return the montoBaseDescuentoItemMonedaOriginal
//     */
//    public double getMontoBaseDescuentoItemMonedaOriginal() {
//        return montoBaseDescuentoItemMonedaOriginal;
//    }
//
//    /**
//     * @param montoBaseDescuentoItemMonedaOriginal the montoBaseDescuentoItemMonedaOriginal to set
//     */
//    public void setMontoBaseDescuentoItemMonedaOriginal(double montoBaseDescuentoItemMonedaOriginal) {
//        this.montoBaseDescuentoItemMonedaOriginal = montoBaseDescuentoItemMonedaOriginal;
//    }

//    /**
//     * @return the porcentajeDescuentoItem
//     */
//    public double getPorcentajeDescuentoItem() {
//        return porcentajeDescuentoItem;
//    }
//
//    /**
//     * @param porcentajeDescuentoItem the porcentajeDescuentoItem to set
//     */
//    public void setPorcentajeDescuentoItem(double porcentajeDescuentoItem) {
//        this.porcentajeDescuentoItem = porcentajeDescuentoItem;
//    }

    /**
     * @return the detaDocBen
     */
//    public ArrayList<lDetalleDocVentaBean> getDetaDocBen(List<String[]> detalle) {
//        String[] cadena;
//        ArrayList<lDetalleDocVentaBean> listDetaDV = new ArrayList<>();
//        int nroOrden = 1;
//        for (String[] cad : detalle){
//            ArrayList<lImpuestoBean> listaImp = new ArrayList<>();
//            //System.out.println(cad);
//            lDetalleDocVentaBean detaB = new lDetalleDocVentaBean(); 
//            detaB.setoDocVenta(null);
//            oProductoBean prodB = new oProductoBean();
//            lImpuestoBean impB = new lImpuestoBean();
//            
//            //codigoUnidadMedida
//            prodB.setCodigoUnidadMedida(cad[0]);
//            //camtidad
//            detaB.setCantidad(Double.parseDouble(cad[1]));
//            //codigoProducto
//            if (cad[3].equals("-")){
//                prodB.setCodigo(null);
//            }else{
//                prodB.setCodigo(cad[2]);
//            }
//            
//            //codigoSunat
//            if (cad[3].equals("-")){
//                prodB.setCodigoSunat(null);
//            }else{
//                prodB.setCodigoSunat(cad[3]);
//            }
//            
//            //descripcion
//            prodB.setDescripcion(cad[4]);
//            //MontoValorVentaUnitarioMonedaOriginal
//            detaB.setMontoValorVentaUnitarioMonedaOriginal(Double.parseDouble(cad[5]));
//            //MontoTotalMonedaOriginal impuesto Productos
//            impB.setMontoTotalMonedaOriginal(Double.parseDouble(cad[6]));
//            //Codigo de Tributo
//            impB.setCodigo(cad[7]);
//            //Monto sin impuesto
//            impB.setMontoBaseMonedaOriginal(Double.parseDouble(cad[9]));
//            //Nombre del tributo
//            impB.setNombre(cad[10]);
//            //CODIGO DE TRIBUTO
//            impB.setCodigoInternacional(cad[11]);
//            //Codigo de afectacion
//            impB.setCodigoTipoAfectacionIGV(cad[12]);
//            //Porcentaje de IGV
//            impB.setPorcentaje(Double.parseDouble(cad[13]));
//            listaImp.add(impB);            
//            //Monto total inc IGV por cad item
//            if (cad[27].equals("7152")){
//               lImpuestoBean impBolsa = new lImpuestoBean();
//               impBolsa.setCodigo(cad[27]);
//               impBolsa.setMontoTotalMonedaOriginal(Double.parseDouble(cad[28]));
//               impBolsa.setCantidadBolsas(new BigInteger(cad[29]));
//               this.cantiBolsas = this.cantiBolsas + Integer.parseInt(cad[29]);
//               impBolsa.setNombre(cad[30]);
//               impBolsa.setCodigoInternacional(cad[31]);
//               //impBolsa.setPorcentaje(null);
//               impBolsa.setValorBolsas(new BigDecimal(cad[32]));
//               listaImp.add(impBolsa);
//               
//            }
//            detaB.setMontoTotalMonedaOriginal(Double.parseDouble(cad[33])*Double.parseDouble(cad[1]));
//            //Monto sin impuesto Detalle
//            detaB.setMontoValorVentaTotalMonedaOriginal(Double.parseDouble(cad[34]));
//            detaB.setMontoDescuentoItemMonedaOriginal(0);
//            
//            
//            //Numero de Orden
//            detaB.setNumeroOrden(nroOrden);
//            detaB.setoProducto(prodB);
//            detaB.setlImpuesto(listaImp);
//                    
//            detaB.setMontoPrecioVentaUnitarioMonedaOriginal(Double.parseDouble(cad[33]));
//            listDetaDV.add(detaB);
//            nroOrden++;
//        }
//       
//        return listDetaDV;
//    }




    
    
    
}
