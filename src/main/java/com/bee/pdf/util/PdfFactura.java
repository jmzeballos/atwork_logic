/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.pdf.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Lealva
 */
public class PdfFactura {
    public String createPDF(String respuestaSunat, String json) {    
        
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        JsonParser parser = new JsonParser();
        Object obj = parser.parse(json);
        JsonObject jsonObject = (JsonObject) obj;
        JsonObject objEmisor = jsonObject.getAsJsonObject("oEmisor");
        Font textoNegrita = new Font(Font.getFamily("montserrat"), 9, Font.BOLD, BaseColor.BLACK);
        Font textoNormal = new Font(Font.FontFamily.UNDEFINED, 8, Font.NORMAL, BaseColor.BLACK);
        Font textoNormal7 = new Font(Font.FontFamily.UNDEFINED,7 , Font.NORMAL, BaseColor.BLACK);
        Font textoFooter = new Font(Font.FontFamily.UNDEFINED, 7, Font.UNDEFINED, BaseColor.BLACK);
        PdfWriter pw = null;
        Document document = new Document(PageSize.A4, 36, 36, 36, 36);
        try {
            pw = PdfWriter.getInstance(document, arrayOutputStream);

        } catch (DocumentException ex) {
            Logger.getLogger(PdfFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        document.open();
  
        document.addTitle("Comprobante de Pago");
        Image logoPrize;
        try {
            URL urlimagen = PdfFactura.class.getResource("/img/prize.png");
            logoPrize = Image.getInstance(urlimagen);
            logoPrize.scaleToFit(80, 80);            
            document.add(logoPrize);
        } catch (MalformedURLException ex) {
            Logger.getLogger(PdfFactura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadElementException ex) {
            Logger.getLogger(PdfFactura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(PdfFactura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PdfFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            document.add(new Phrase(Chunk.NEWLINE));
            /*DATOS DE LA EMPRESA*/
            PdfPTable tablecabecera = new PdfPTable(3);
            PdfPCell celdocizquierda = new PdfPCell();
            Paragraph nombrecomercial = new Paragraph();
            nombrecomercial.add(new Phrase(objEmisor.get("nombreComercial").getAsString(), textoNormal));
            celdocizquierda.addElement(nombrecomercial);
            Paragraph razonscocial = new Paragraph();
            razonscocial.add(new Phrase(objEmisor.get("apellidosNombresDenominacionRazonSocial").getAsString(), textoNegrita));
            celdocizquierda.addElement(razonscocial);
            Paragraph direccion = new Paragraph();
            direccion.add(new Phrase(objEmisor.get("direccion").getAsString(), textoNormal7));
            celdocizquierda.addElement(direccion);
            Paragraph referenciadistrito = new Paragraph();
            referenciadistrito.add(new Phrase(objEmisor.get("distrito").getAsString() + "-" + objEmisor.get("provincia").getAsString() + "-" + objEmisor.get("departamento").getAsString(), textoNormal7));
            celdocizquierda.addElement(referenciadistrito);
            celdocizquierda.setColspan(2);
            celdocizquierda.setBorder(Rectangle.NO_BORDER);
            tablecabecera.addCell(celdocizquierda);
            PdfPCell celdadocderecha = new PdfPCell();
            Paragraph tipodocumneto = new Paragraph();
            tipodocumneto.add(new Phrase("BOLETA DE VENTA ELECTRONICA", textoNormal));
            tipodocumneto.setAlignment(Element.ALIGN_CENTER);
            celdadocderecha.addElement(tipodocumneto);
            Paragraph rucempresa = new Paragraph();
            rucempresa.add(new Phrase("RUC: " + objEmisor.get("numeroDocumentoIdentidad").getAsString(), textoNormal));
            rucempresa.setAlignment(Element.ALIGN_CENTER);
            celdadocderecha.addElement(rucempresa);
            Paragraph serienumero = new Paragraph();
            serienumero.add(new Phrase(jsonObject.get("numeroSerie").getAsString() + "-" + jsonObject.get("numeroCorrelativo").getAsString(), textoNormal));
            serienumero.setAlignment(Element.ALIGN_CENTER);
            celdadocderecha.addElement(serienumero);
            tablecabecera.addCell(celdadocderecha);
            tablecabecera.setWidthPercentage(100);
            document.add(tablecabecera);
            document.add(new Phrase(Chunk.NEWLINE));
            LineSeparator ls = new LineSeparator();
            ls.setLineColor(BaseColor.BLACK);
            ls.setPercentage(100);
            document.add(ls);
            /*DATOS DEL CLIENTE*/
            PdfPTable tablecliente = new PdfPTable(4);
            PdfPCell celdocizquierdacliente = new PdfPCell();
            Paragraph fechaemmision = new Paragraph();
            fechaemmision.add(new Phrase("Fecha de Emisión", textoNegrita));
            celdocizquierdacliente.addElement(fechaemmision);
            Paragraph nombrecliente = new Paragraph();
            nombrecliente.add(new Phrase("Señor(es)", textoNegrita));
            celdocizquierdacliente.addElement(nombrecliente);
            Paragraph dnicliente = new Paragraph();
            dnicliente.add(new Phrase("DNI", textoNegrita));
            celdocizquierdacliente.addElement(dnicliente);
            Paragraph tipomoneda = new Paragraph();
            tipomoneda.add(new Phrase("Tipo de Moneda", textoNegrita));
            celdocizquierdacliente.addElement(tipomoneda);
            celdocizquierdacliente.setBorder(Rectangle.NO_BORDER);
            tablecliente.addCell(celdocizquierdacliente);
            JsonObject obtAdquiere = jsonObject.getAsJsonObject("oAdquiriente");
            PdfPCell celdaderechacliente = new PdfPCell();
           
            Paragraph fechaemmisionderecha = new Paragraph();
            fechaemmisionderecha.add(new Phrase(":  " + jsonObject.get("fechaEmision").getAsString().substring(0, 10), textoNormal));
            celdaderechacliente.addElement(fechaemmisionderecha);
            Paragraph nombreclientederecha = new Paragraph();
            nombreclientederecha.add(new Phrase(":  " + obtAdquiere.get("apellidosNombresDenominacionRazonSocial").getAsString(), textoNormal));
            celdaderechacliente.addElement(nombreclientederecha);
            Paragraph dniclientederecha = new Paragraph();
            dniclientederecha.add(new Phrase(":  " + obtAdquiere.get("numeroDocumentoIdentidad").getAsString(), textoNormal));
            celdaderechacliente.addElement(dniclientederecha);
            Paragraph tipomonedaderecha = new Paragraph();
            tipomonedaderecha.add(new Phrase(":  " + "SOLES", textoNormal));
            celdaderechacliente.addElement(tipomonedaderecha);
            celdaderechacliente.setColspan(3);
            celdaderechacliente.setBorder(Rectangle.NO_BORDER);
            tablecliente.addCell(celdaderechacliente);
            tablecliente.setWidthPercentage(100);
            document.add(tablecliente);
            Paragraph espacio = new Paragraph(Chunk.NEWLINE);
            document.add(espacio);
            LineSeparator separador = new LineSeparator();
            separador.setLineColor(BaseColor.BLACK);
            separador.setPercentage(100);
            separador.setLineWidth(0);
            document.add(separador);
            /*CABECERA DEL DETALLE*/
            PdfPTable tabledetallecompra = new PdfPTable(8);
            PdfPCell celdacabeceracodigo = new PdfPCell();
            Paragraph tituloxodigo = new Paragraph();
            tituloxodigo.add(new Phrase("Código", textoNegrita));
            tituloxodigo.setAlignment(Element.ALIGN_CENTER);
            celdacabeceracodigo.addElement(tituloxodigo);
            celdacabeceracodigo.setBorder(Rectangle.NO_BORDER);
            celdacabeceracodigo.setPaddingBottom(10);
            tabledetallecompra.addCell(celdacabeceracodigo);
            PdfPCell celdacabeceradescripcion = new PdfPCell();
            Paragraph titulodescripcion = new Paragraph();
            titulodescripcion.add(new Phrase("Descripción", textoNegrita));
            titulodescripcion.setAlignment(Element.ALIGN_CENTER);
            celdacabeceradescripcion.addElement(titulodescripcion);
            celdacabeceradescripcion.setColspan(3);
            celdacabeceradescripcion.setBorder(Rectangle.NO_BORDER);
            celdacabeceradescripcion.setPaddingBottom(10);
            tabledetallecompra.addCell(celdacabeceradescripcion);
            PdfPCell celdacabeceracantidad = new PdfPCell();
            Paragraph titulocantidad = new Paragraph();
            titulocantidad.add(new Phrase("Cantidad", textoNegrita));
            titulocantidad.setAlignment(Element.ALIGN_CENTER);
            celdacabeceracantidad.addElement(titulocantidad);
            celdacabeceracantidad.setPaddingBottom(10);
            celdacabeceracantidad.setBorder(Rectangle.NO_BORDER);
            tabledetallecompra.addCell(celdacabeceracantidad);
            PdfPCell celdacabeceraunidadmedida = new PdfPCell();
            Paragraph titulounidadmedida = new Paragraph();
            titulounidadmedida.add(new Phrase("U. Medida", textoNegrita));
            titulounidadmedida.setAlignment(Element.ALIGN_CENTER);
            celdacabeceraunidadmedida.addElement(titulounidadmedida);
            celdacabeceraunidadmedida.setPaddingBottom(10);
            celdacabeceraunidadmedida.setBorder(Rectangle.NO_BORDER);
            tabledetallecompra.addCell(celdacabeceraunidadmedida);
            PdfPCell celdacabeceravalorunit = new PdfPCell();
            Paragraph titulovalorunit = new Paragraph();
            titulovalorunit.add(new Phrase("Valor Unit.", textoNegrita));
            titulovalorunit.setAlignment(Element.ALIGN_CENTER);
            celdacabeceravalorunit.addElement(titulovalorunit);
            celdacabeceravalorunit.setPaddingBottom(10);
            celdacabeceravalorunit.setBorder(Rectangle.NO_BORDER);
            tabledetallecompra.addCell(celdacabeceravalorunit);
            PdfPCell celdacabeceraimporte = new PdfPCell();
            Paragraph tituloimporte = new Paragraph();
            tituloimporte.add(new Phrase("Importe", textoNegrita));
            tituloimporte.setAlignment(Element.ALIGN_CENTER);
            celdacabeceraimporte.addElement(tituloimporte);
            celdacabeceraimporte.setPaddingBottom(10);
            celdacabeceraimporte.setBorder(Rectangle.NO_BORDER);
            tabledetallecompra.addCell(celdacabeceraimporte);
            tabledetallecompra.setWidthPercentage(100);
            document.add(tabledetallecompra);
            document.add(separador);
            /*CUERPO DEL DETALLE*/
            JsonArray arrayDetalleBoleta = jsonObject.getAsJsonArray("lDetalleBoletaVenta");
            if (arrayDetalleBoleta.size() > 0) {
                for (int i = 0; i < arrayDetalleBoleta.size(); i++) {
                    JsonObject objetoDetalleVenta = arrayDetalleBoleta.get(i).getAsJsonObject();
                    JsonObject objetProducto = objetoDetalleVenta.getAsJsonObject("oProducto");
                    PdfPTable tabledetalle = new PdfPTable(8);
                    PdfPCell celdadetallecodigo = new PdfPCell();
                    Paragraph codigo = new Paragraph();
                    codigo.add(new Phrase(objetProducto.get("codigo").getAsString(), textoNormal));
                    codigo.setAlignment(Element.ALIGN_CENTER);
                    celdadetallecodigo.addElement(codigo);
                    celdadetallecodigo.setBorder(Rectangle.NO_BORDER);
                    celdadetallecodigo.setPaddingBottom(10);
                    tabledetalle.addCell(celdadetallecodigo);
                    PdfPCell celdadetalledescripcion = new PdfPCell();
                    Paragraph descripcion = new Paragraph();
                    descripcion.add(new Phrase(objetProducto.get("descripcion").getAsString(), textoNormal));
                    descripcion.setAlignment(Element.ALIGN_CENTER);
                    celdadetalledescripcion.addElement(descripcion);
                    celdadetalledescripcion.setColspan(3);
                    celdadetalledescripcion.setBorder(Rectangle.NO_BORDER);
                    celdadetalledescripcion.setPaddingBottom(10);
                    tabledetalle.addCell(celdadetalledescripcion);
                    PdfPCell celdadetallecantidad = new PdfPCell();
                    Paragraph cantidad = new Paragraph();
                    cantidad.add(new Phrase(objetoDetalleVenta.get("cantidad").getAsString(), textoNormal));
                    cantidad.setAlignment(Element.ALIGN_CENTER);
                    celdadetallecantidad.addElement(cantidad);
                    celdadetallecantidad.setPaddingBottom(10);
                    celdadetallecantidad.setBorder(Rectangle.NO_BORDER);
                    tabledetalle.addCell(celdadetallecantidad);
                    PdfPCell celdadetalleunidadmedida = new PdfPCell();
                    Paragraph unidadmedida = new Paragraph();
                    unidadmedida.add(new Phrase(objetProducto.get("codigoUnidadMedida").getAsString(), textoNormal));
                    unidadmedida.setAlignment(Element.ALIGN_CENTER);
                    celdadetalleunidadmedida.addElement(unidadmedida);
                    celdadetalleunidadmedida.setPaddingBottom(10);
                    celdadetalleunidadmedida.setBorder(Rectangle.NO_BORDER);
                    tabledetalle.addCell(celdadetalleunidadmedida);
                    PdfPCell celdadetallevalorunit = new PdfPCell();
                    Paragraph valorunit = new Paragraph();
                    valorunit.add(new Phrase(objetoDetalleVenta.get("montoPrecioVentaUnitarioMonedaOriginal").getAsString(), textoNormal));
                    valorunit.setAlignment(Element.ALIGN_CENTER);
                    celdadetallevalorunit.addElement(valorunit);
                    celdadetallevalorunit.setPaddingBottom(10);
                    celdadetallevalorunit.setBorder(Rectangle.NO_BORDER);
                    tabledetalle.addCell(celdadetallevalorunit);
                    PdfPCell celdadetalleimporte = new PdfPCell();
                    Paragraph importe = new Paragraph();
                    importe.add(new Phrase(objetoDetalleVenta.get("montoTotalMonedaOriginal").getAsString(), textoNormal));
                    importe.setAlignment(Element.ALIGN_CENTER);
                    celdadetalleimporte.addElement(importe);
                    celdadetalleimporte.setPaddingBottom(10);
                    celdadetalleimporte.setBorder(Rectangle.NO_BORDER);
                    tabledetalle.addCell(celdadetalleimporte);
                    tabledetalle.setWidthPercentage(100);
                    document.add(tabledetalle);
                    document.add(separador);

                }
                document.add(espacio);
            }
            /*CODIGO DE BARRA*/
            PdfPTable table = new PdfPTable(5);
            PdfPCell cell;
            cell = new PdfPCell();
            String contenidocodigobarra = objEmisor.get("numeroDocumentoIdentidad").getAsString() + "|"
                    + jsonObject.get("codigoTipoDocumento").getAsString() + "|" + jsonObject.get("numeroSerie").getAsString() + "|"
                    + jsonObject.get("numeroCorrelativo").getAsString() + "|" + jsonObject.get("montoImpuestoMonedaOriginal").getAsString() + "|" + jsonObject.get("montoTotalMonedaOriginal").getAsString()
                    + "|" + jsonObject.get("fechaEmision").getAsString().substring(0, 10) + "|"
                    + obtAdquiere.get("codigoTipoDocumentoIdentidad").getAsString() + "|"
                    + obtAdquiere.get("numeroDocumentoIdentidad").getAsString();
            BarcodeQRCode barcodeQRCode = new BarcodeQRCode(contenidocodigobarra, 1500, 1500, null);
            Image codeQrImage = barcodeQRCode.getImage();
            codeQrImage.scaleToFit(1000, 1000);
            cell.addElement(codeQrImage);
            cell.setRowspan(8);
            cell.setColspan(3);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            Paragraph montoafecto = new Paragraph();
            montoafecto.add(new Phrase("Op. Inafecta :", textoNegrita));
            montoafecto.setAlignment(Element.ALIGN_RIGHT);
            PdfPCell cellmontoafecta = new PdfPCell();
            // cellmontoafecta.setPaddingBottom(10);
            cellmontoafecta.addElement(montoafecto);
            cellmontoafecta.setBorder(Rectangle.NO_BORDER);

            table.addCell(cellmontoafecta);
            Paragraph valinafecta = new Paragraph();
            valinafecta.add(new Phrase("S/ " + "0.00", textoNormal));
            valinafecta.setAlignment(Element.ALIGN_RIGHT);
            PdfPCell cellvalinafecta = new PdfPCell();
            //  cellvalinafecta.setPaddingBottom(10);
            cellvalinafecta.setCellEvent(new roudTotales());
            cellvalinafecta.addElement(valinafecta);
            cellvalinafecta.setBorder(Rectangle.NO_BORDER);
            table.addCell(cellvalinafecta);
            Paragraph montoexonera = new Paragraph();
            montoexonera.add(new Phrase("Op. Exonerada :", textoNegrita));
            montoexonera.setAlignment(Element.ALIGN_RIGHT);
            PdfPCell cellmontoexonera = new PdfPCell();
            // cellmontoexonera.setPaddingBottom(10);
            cellmontoexonera.addElement(montoexonera);
            cellmontoexonera.setBorder(Rectangle.NO_BORDER);
            table.addCell(cellmontoexonera);
            Paragraph valexonera = new Paragraph();
            valexonera.add(new Phrase("S/ " + "0.00", textoNormal));
            valexonera.setAlignment(Element.ALIGN_RIGHT);
            PdfPCell cellvalexonera = new PdfPCell();
            // cellvalexonera.setPaddingBottom(10);
            cellvalexonera.addElement(valexonera);
            cellvalexonera.setCellEvent(new roudTotales());
            cellvalexonera.setBorder(Rectangle.NO_BORDER);
            table.addCell(cellvalexonera);
            Paragraph montogratuita = new Paragraph();
            montogratuita.add(new Phrase("Total Op. Gratuitas :", textoNegrita));
            montogratuita.setAlignment(Element.ALIGN_RIGHT);
            PdfPCell cellmontogratuita = new PdfPCell();
            //  cellmontogratuita.setPaddingBottom(10);
            cellmontogratuita.addElement(montogratuita);
            cellmontogratuita.setBorder(Rectangle.NO_BORDER);
            table.addCell(cellmontogratuita);
            Paragraph valgratuita = new Paragraph();
            valgratuita.add(new Phrase("S/ " + "0.00", textoNormal));
            valgratuita.setAlignment(Element.ALIGN_RIGHT);
            PdfPCell cellvalgratuita = new PdfPCell();
            //  cellvalgratuita.setPaddingBottom(10);
            cellvalgratuita.addElement(valgratuita);
            cellvalgratuita.setCellEvent(new roudTotales());
            cellvalgratuita.setBorder(Rectangle.NO_BORDER);
            table.addCell(cellvalgratuita);
            Paragraph montoglobal = new Paragraph();
            montoglobal.add(new Phrase("Dscto. Global :", textoNegrita));
            montoglobal.setAlignment(Element.ALIGN_RIGHT);
            PdfPCell cellmontoglobal = new PdfPCell();
            //  cellmontoglobal.setPaddingBottom(10);
            cellmontoglobal.addElement(montoglobal);
            cellmontoglobal.setBorder(Rectangle.NO_BORDER);
            table.addCell(cellmontoglobal);
            Paragraph valglobal = new Paragraph();
            valglobal.add(new Phrase("S/ " + "0.00", textoNormal));
            valglobal.setAlignment(Element.ALIGN_RIGHT);
            PdfPCell cellvalglobal = new PdfPCell();
            //  cellvalglobal.setPaddingBottom(10);
            cellvalglobal.addElement(valglobal);
            cellvalglobal.setCellEvent(new roudTotales());
            cellvalglobal.setBorder(Rectangle.NO_BORDER);
            table.addCell(cellvalglobal);
            Paragraph montototal = new Paragraph();
            montototal.add(new Phrase("Dscto. Total :", textoNegrita));
            montototal.setAlignment(Element.ALIGN_RIGHT);
            PdfPCell cellmontototal = new PdfPCell();
            //   cellmontototal.setPaddingBottom(10);
            cellmontototal.addElement(montototal);
            cellmontototal.setBorder(Rectangle.NO_BORDER);
            table.addCell(cellmontototal);
            Paragraph valdesctotal = new Paragraph();
            valdesctotal.add(new Phrase("S/ " + "0.00", textoNormal));
            valdesctotal.setAlignment(Element.ALIGN_RIGHT);
            PdfPCell cellvaldestotal = new PdfPCell();
            // cellvaldestotal.setPaddingBottom(10);
            cellvaldestotal.addElement(valdesctotal);
            cellvaldestotal.setCellEvent(new roudTotales());
            cellvaldestotal.setBorder(Rectangle.NO_BORDER);
            table.addCell(cellvaldestotal);
            Paragraph montogravada = new Paragraph();
            montogravada.add(new Phrase("Op. Gravada :", textoNegrita));
            montogravada.setAlignment(Element.ALIGN_RIGHT);
            PdfPCell cellmontogravada = new PdfPCell();
            //  cellmontogravada.setPaddingBottom(10);
            cellmontogravada.addElement(montogravada);
            cellmontogravada.setBorder(Rectangle.NO_BORDER);
            table.addCell(cellmontogravada);
            Paragraph valgravada = new Paragraph();
            valgravada.add(new Phrase("S/ " + jsonObject.get("montoValorVentaMonedaOriginal").getAsString(), textoNormal));
            valgravada.setAlignment(Element.ALIGN_RIGHT);
            PdfPCell cellvalgravada = new PdfPCell();
            //  cellvalgravada.setPaddingBottom(10);
            cellvalgravada.addElement(valgravada);
            cellvalgravada.setCellEvent(new roudTotales());
            cellvalgravada.setBorder(Rectangle.NO_BORDER);
            table.addCell(cellvalgravada);
            Paragraph montoigv = new Paragraph();
            montoigv.add(new Phrase("18 % IGV :", textoNegrita));
            montoigv.setAlignment(Element.ALIGN_RIGHT);
            PdfPCell cellmontoigv = new PdfPCell();
            //   cellmontoigv.setPaddingBottom(10);
            cellmontoigv.addElement(montoigv);
            cellmontoigv.setBorder(Rectangle.NO_BORDER);
            table.addCell(cellmontoigv);
            Paragraph valigv = new Paragraph();
            valigv.add(new Phrase("S/ " + jsonObject.get("montoImpuestoMonedaOriginal").getAsString(), textoNormal));
            valigv.setAlignment(Element.ALIGN_RIGHT);
            PdfPCell cellvaligv = new PdfPCell();
            //   cellvaligv.setPaddingBottom(10);
            cellvaligv.addElement(valigv);
            cellvaligv.setCellEvent(new roudTotales());
            cellvaligv.setBorder(Rectangle.NO_BORDER);
            table.addCell(cellvaligv);
            table.setWidthPercentage(100);
            document.add(table);
            JsonArray arrayNota = jsonObject.getAsJsonArray("lNota");
            JsonObject objNota = arrayNota.get(0).getAsJsonObject();
            PdfPTable tableinferior = new PdfPTable(5);
            Paragraph totalletras = new Paragraph();
            totalletras.add(new Phrase("SON: " + objNota.get("descripcion").getAsString(), textoNormal));
            totalletras.setAlignment(Element.ALIGN_CENTER);
            PdfPCell cellnombretexto = new PdfPCell();
            cellnombretexto.setRowspan(1);
            cellnombretexto.setColspan(3);
            cellnombretexto.setBorder(Rectangle.NO_BORDER);
            cellnombretexto.addElement(totalletras);
            tableinferior.addCell(cellnombretexto);
            Paragraph montototales = new Paragraph();
            montototales.add(new Phrase("Total :", textoNegrita));
            montototales.setAlignment(Element.ALIGN_RIGHT);
            PdfPCell cellmontototales = new PdfPCell();
            //  cellmontototales.setPaddingBottom(10);
            cellmontototales.addElement(montototales);
            cellmontototales.setBorder(Rectangle.NO_BORDER);
            tableinferior.addCell(cellmontototales);
            Paragraph valtotales = new Paragraph();
            valtotales.add(new Phrase("S/ " + jsonObject.get("montoTotalMonedaOriginal").getAsString(), textoNormal));
            valtotales.setAlignment(Element.ALIGN_RIGHT);
            PdfPCell cellvaltotales = new PdfPCell();
            //   cellvaltotales.setPaddingBottom(10);
            cellvaltotales.addElement(valtotales);
            cellvaltotales.setCellEvent(new roudTotales());
            cellvaltotales.setBorder(Rectangle.NO_BORDER);

            tableinferior.addCell(cellvaltotales);
            tableinferior.setWidthPercentage(100);
            document.add(tableinferior);
            /*FOOTER DE HOJA*/
            PdfPTable footer = new PdfPTable(1);
            PdfPCell cellls = new PdfPCell();
            cellls.setBorder(Rectangle.TOP);
            cellls.setBorderColor(BaseColor.BLACK);
            footer.addCell(cellls);
            Phrase termino1 = new Phrase();
            termino1.setFont(textoFooter);
            termino1.add("Representación impresa de la boleta de venta electrónica");
            PdfPCell Celltermino1 = new PdfPCell(termino1);
            Celltermino1.setBorder(0);
            footer.addCell(Celltermino1);
         /*   Phrase termino2 = new Phrase();
            termino2.setFont(textoFooter);
            termino2.add("Autorizado mediante Resolución N° 0180050001355/SUNAT");
            PdfPCell Celltermino2 = new PdfPCell(termino2);
            Celltermino2.setBorder(0);
            footer.addCell(Celltermino2);*/
            Phrase termino3 = new Phrase();
            termino3.setFont(textoFooter);
            termino3.add("Valor Resumen  " + respuestaSunat);
            PdfPCell Celltermino3 = new PdfPCell(termino3);
            Celltermino3.setBorder(0);
            footer.addCell(Celltermino3);
            footer.setTotalWidth(520);
            footer.setLockedWidth(true);
            footer.writeSelectedRows(0, -1, 34, 60, pw.getDirectContent());

        } catch (DocumentException ex) {
            Logger.getLogger(PdfFactura.class.getName()).log(Level.SEVERE, null, ex);
        }

        document.close();
          byte[] byteArrayPDF = arrayOutputStream.toByteArray();
         String stringPDF = Base64.getEncoder().encodeToString(byteArrayPDF);
        return stringPDF;
    }
}
