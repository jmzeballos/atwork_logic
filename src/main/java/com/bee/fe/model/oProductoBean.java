
package com.bee.fe.model;

/**
 *
 * @author j.Zeballos
 */
public class oProductoBean {

    /**
     * @return the codigoSunat
     */
    public String getCodigoSunat() {
        return codigoSunat;
    }

    /**
     * @param codigoSunat the codigoSunat to set
     */
    public void setCodigoSunat(String codigoSunat) {
        this.codigoSunat = codigoSunat;
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

    private String codigoUnidadMedida;
    private String descripcion;
    private String codigoSunat;
    private String codigo;
    
    public oProductoBean() {
    }

    public String getCodigoUnidadMedida() {
        return codigoUnidadMedida;
    }

    public void setCodigoUnidadMedida(String codigoUnidadMedida) {
        this.codigoUnidadMedida = codigoUnidadMedida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
