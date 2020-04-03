package com.bee.fe.model;

import com.google.gson.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class createJson {

    /**
     * @return the REL
     */
    public List<String[]> getREL() {
        return REL;
    }

    /**
     * @param REL the REL to set
     */
    public void setREL(List<String[]> REL) {
        this.REL = REL;
    }

    private String setJson;
    private String[] CAB;
    private ArrayList<lDetalleDocVentaBean> DET;
    private ArrayList<lImpuestoBean> TRI;
    private String[] LEY;
    private List<String> EMAIL;
    private String nFile;
    private lDetalleDocVentaBean detalleVentaB = null;
    private List<String[]> REL;
    private String tipoDoc;

    public createJson() {
        this.detalleVentaB = new lDetalleDocVentaBean();

    }

    /**
     * @return the DET
     */
    public ArrayList<lDetalleDocVentaBean> getDET() {
        return DET;
    }

    /**
     * @param DET the DET to set
     */
    public void setDET(ArrayList<lDetalleDocVentaBean> DET) {
        this.DET = DET;
    }


//    public String setJson() throws IOException {
//        Map<String, Object> datosEnv = new HashMap();
//        readFile rf = new readFile();
//        String[] nsFile = this.nFile.split("-");
//
//        String rucEmisor = this.getnFile().substring(0, 11);
//        oEmisorJson emiJson = new oEmisorJson();
//        emiJson.setEmiJson(rucEmisor);
//
//        oEmisorBean emiBean = emiJson.getoEmiBean();
//        oAdquirienteBean adquiBean = new oAdquirienteBean();
//        lImpuestoBean impBean = new lImpuestoBean();
//        lNotaBean notaBean = new lNotaBean();
//
//        ArrayList<lDetalleDocVentaBean> listDetalle = this.detalleVentaB.getDetaDocBen(rf.getContentDetalle(this.getnFile() + ".DET"));
//        
//        
//        if (this.fileExists(this.getnFile() + ".REL")) {
//            1: Guía, 2: Anticipo, 3: Orden de compra, 98: Documentos afectados (múltiples) por una Nota de Crédito / Débido,  99: Otros
//            this.setREL(rf.getContentREL(this.getnFile() + ".REL"));
//            List<String[]> rels = this.getREL();
//            for (int j = 0; j < rels.size(); j++) {
//                String[] line = rels.get(j);
//                String indicador = line[0];
//                if (indicador.equals("1")) {
//                    lDocumentoReferenciaEnvioBean guiaBean = new lDocumentoReferenciaEnvioBean();
//                    guiaBean.setCodigoTipoDocumento(line[2]);
//                    guiaBean.setNumero(line[3]);
//                    ArrayList<lDocumentoReferenciaEnvioBean> listaGuias = new ArrayList<>();
//                    listaGuias.add(guiaBean);
//                    datosEnv.put("lDocumentoReferenciaEnvio", listaGuias);
//                } else if (indicador.equals("3")) {
//                    parametrosAdicionalesReporteBean paramBean = new parametrosAdicionalesReporteBean();
//                    paramBean.setOrdencompra(line[3]);
//                    paramBean.setTotalapagar(line[6]);
//                    datosEnv.put("parametrosAdicionalesReporte", paramBean);
//                }
//            }
//        } else {
//            datosEnv.put("parametrosAdicionalesReporte", null);
//        }
//
//        
//        emiBean.setCodigoEstablecimientoAnexo(this.getCAB()[4]);
//
//        inserta detalle del doc de venta
//        datosEnv.put("lDetalleBoletaVenta", listDetalle);
//        if (nsFile[1].equals("01")) {
//            datosEnv.put("lDetalleFactura", listDetalle);
//        } else if (nsFile[1].equals("03")) {
//            datosEnv.put("lDetalleBoletaVenta", listDetalle);
//        }
//
//        datosEnv.put("codigoTipoOperacion", this.getCAB()[0]);
//        datosEnv.put("horaEmision", this.getCAB()[1] + "T" + this.getCAB()[2] + "-05:00");
//        datosEnv.put("fechaEmision", this.getCAB()[1] + "T00:00:00-05:00");
//        datosEnv.put("fechaVencimiento", null);
//        datosEnv.put("montoValorVentaMonedaOriginal", Double.parseDouble(this.getCAB()[10]));
//        datosEnv.put("montoTotalMonedaOriginal", Double.parseDouble(this.getCAB()[11]));
//        datosEnv.put("montoTotalDescuentoMonedaOriginal", null);
//        datosEnv.put("montoImpuestoMonedaOriginal", impBean.getMontoTotalMonedaOriginalGeneral());
//        datosEnv.put("lMedioPago", new String[]{});
//        datosEnv.put("lTerminoPago", new String[]{});
//
//        datosEnv.put("lDocumentoReferenciaAdicional", new String[]{});
//
//        adquiBean.setCodigoTipoDocumentoIdentidad(this.getCAB()[5]);
//        adquiBean.setNumeroDocumentoIdentidad(this.getCAB()[6]);
//        adquiBean.setApellidosNombresDenominacionRazonSocial(this.getCAB()[7]);
//
//        datosEnv.put("codigoTipoMoneda", this.getCAB()[8]);
//
//
//        impBean.setCodigo(this.getTRI()[0]);
//        impBean.setNombre(this.getTRI()[1]);
//        impBean.setCodigoInternacional(this.getTRI()[2]);
//        impBean.setMontoBaseMonedaOriginal(Double.parseDouble(this.getTRI()[3]));
//        impBean.setMontoTotalMonedaOriginal(Double.parseDouble(this.getTRI()[4]));
//
//
//        notaBean.setCodigo(this.getLEY()[0]);
//        notaBean.setDescripcion(this.getLEY()[1]);
//
//        datosEnv.put("codigoTipoDocumento", nsFile[1]);
//        this.setTipoDoc(nsFile[1]);
//        datosEnv.put("numeroSerie", nsFile[2]);
//        datosEnv.put("numeroCorrelativo", nsFile[3]);
//        inserta datos del emisor
//        datosEnv.put("oEmisor", emiBean);
//        inserta datos del adquiriente
//        datosEnv.put("oAdquiriente", adquiBean);
//        inserta datos del impuestos
//        ArrayList<lImpuestoBean> listaImp = new ArrayList<>();
//        listaImp.add(impBean);
//        datosEnv.put("lImpuesto", this.getTRI());
//        inserta datos de Nota -LEY
//        ArrayList<lNotaBean> listanotaBean = new ArrayList<>();
//        listanotaBean.add(notaBean);
//        datosEnv.put("lNota", listanotaBean);
//
//        Gson gson = new Gson();
//        String jsonOutput = gson.toJson(datosEnv);
//        jsonOutput = jsonOutput.replace("0.0,", "null,");
//        String prettyJson = toPrettyFormat(jsonOutput);
//
//        System.out.println(prettyJson);
//        return jsonOutput;
//    }

//    public static String toPrettyFormat(String jsonString) {
//        JsonParser parser = new JsonParser();
//        JsonObject json = parser.parse(jsonString).getAsJsonObject();
//
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String prettyJson = gson.toJson(json);
//
//        return prettyJson;
//    }

    /**
     * @return the setJson
     */
    public String getSetJson() {
        return setJson;
    }

    /**
     * @param setJson the setJson to set
     */
    public void setSetJson(String setJson) {
        this.setJson = setJson;
    }

    public static void main(String[] args) throws IOException {
        
    }

    /**
     * @return the tipoDoc
     */
    public String getTipoDoc() {
        return tipoDoc;
    }

    /**
     * @param tipoDoc the tipoDoc to set
     */
    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

     public lDetalleDocVentaBean getDetalleVentaB() {
        return detalleVentaB;
    }

    public void setDetalleVentaB(lDetalleDocVentaBean detalleVentaB) {
        this.detalleVentaB = detalleVentaB;
    }

}
