/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.pdf.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lealva
 */
public class GenerarPdf {

    public Document createPDF(Document document, PdfWriter pw, Object objeto, File nombreUbicacionFile) {
        JsonObject jsonObject = (JsonObject) objeto;
        Color colorpersonalizado = new Color(0, 24, 73);
        switch (jsonObject.get("nombreNegocio").getAsString()) {
            case "benefit":
                colorpersonalizado = new Color(0, 24, 73);
                break;
            case "plataforma":
                colorpersonalizado = new Color(0, 24, 73);
                break;
        }
        BaseFont baseFontBold = null;
        BaseFont baseFontRegular = null;
        try {
            baseFontBold = BaseFont.createFont(GenerarPdf.class.getResource("/estilos/TTNorms-Bold.otf").toString(), "Cp1252", true);
            baseFontRegular = BaseFont.createFont(GenerarPdf.class.getResource("/estilos/TTNorms-Regular.otf").toString(), "Cp1252", true);
        } catch (DocumentException ex) {
            Logger.getLogger(GenerarPdf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenerarPdf.class.getName()).log(Level.SEVERE, null, ex);
        }
        Font fontTitulo = new Font(baseFontBold, 15, Font.NORMAL, new BaseColor(colorpersonalizado));
        Font fontTituloNombre = new Font(baseFontBold, 16, Font.NORMAL, new BaseColor(colorpersonalizado));
        Font fontText = new Font(baseFontRegular, 12, Font.NORMAL, new BaseColor(colorpersonalizado));
        try {
            HeaderFooter headerFooter = new HeaderFooter();
            headerFooter.setNombreempresa(jsonObject.get("nombreEmpresa").getAsString());
            headerFooter.setNombrenegocio(jsonObject.get("nombreNegocio").getAsString());
            pw.setPageEvent(headerFooter);
            document.addTitle("Cupones de compra");
            /*============================CUERPO DEL PDF==========================================================*/
            /*=======ENTRADAS=============================*/
            Paragraph paragraphUsuario = new Paragraph();
            paragraphUsuario.add(new Phrase("Hola " + jsonObject.get("nombrecliente").getAsString() + ", estos son tus códigos Cineplanet: ", fontTitulo));
            paragraphUsuario.setAlignment(Element.ALIGN_LEFT);
            paragraphUsuario.add(new Phrase(Chunk.NEWLINE));
            paragraphUsuario.add(new Phrase(Chunk.NEWLINE));
            document.add(paragraphUsuario);
            JsonArray arrayProducto = jsonObject.getAsJsonArray("listProductoCanje").getAsJsonArray();

            for (int i = 0; i < arrayProducto.size(); i++) {

                JsonObject objProduct = arrayProducto.get(i).getAsJsonObject();
                if (objProduct.get("tipoProducto").getAsInt() == 1) {
                    Paragraph paragraphNombreProducto = new Paragraph();
                    if (objProduct.get("cantidad").getAsInt() < 10) {
                        paragraphNombreProducto.add(new Phrase(".0" + objProduct.get("cantidad").getAsInt() + " " + objProduct.get("nombreProducto").getAsString(), fontTituloNombre));
                    } else {
                        paragraphNombreProducto.add(new Phrase("." + objProduct.get("cantidad").getAsInt() + " " + objProduct.get("nombreProducto").getAsString(), fontTituloNombre));
                    }
                    paragraphNombreProducto.setAlignment(Element.ALIGN_LEFT);
                    paragraphNombreProducto.add(new Phrase(Chunk.NEWLINE));
                    document.add(paragraphNombreProducto);
                    Paragraph paragraphComplejo = new Paragraph();
                    paragraphComplejo.add(new Phrase("  Válido para: " + objProduct.get("complejos").getAsString(), fontText));
                    paragraphComplejo.setAlignment(Element.ALIGN_LEFT);
                    paragraphComplejo.add(new Phrase(Chunk.NEWLINE));
                    paragraphComplejo.add(new Phrase(Chunk.NEWLINE));
                    document.add(paragraphComplejo);

                    JsonArray arrayCodigo = objProduct.getAsJsonArray("listaCodigoCanje").getAsJsonArray();
                    for (int j = 0; j < arrayCodigo.size(); j++) {
                        JsonObject objCaodigoCanje = arrayCodigo.get(j).getAsJsonObject();
                        Paragraph paragraphText = new Paragraph();
                        paragraphText.add(new Phrase("  Código para canje", fontText));
                        paragraphText.setAlignment(Element.ALIGN_LEFT);
                        paragraphText.add(new Phrase(Chunk.NEWLINE));
                        paragraphText.add(new Phrase(Chunk.NEWLINE));
                        document.add(paragraphText);
                        Paragraph CodigoEntrada1 = new Paragraph();
                        CodigoEntrada1.add(new Phrase(objCaodigoCanje.get("codigocanje").getAsString(), fontTitulo));
                        CodigoEntrada1.setAlignment(Element.ALIGN_LEFT);
                        CodigoEntrada1.add(new Phrase(Chunk.NEWLINE));
                        PdfPTable tableCodigo = new PdfPTable(1);
                        PdfPCell cellcodigo;
                        cellcodigo = new PdfPCell(CodigoEntrada1);
                        cellcodigo.setPaddingBottom(10);
                        cellcodigo.setCellEvent(new round());
                        cellcodigo.setBorderColor(new BaseColor(colorpersonalizado));
                        cellcodigo.setBorderWidth(1);
                        cellcodigo.setBorder(Rectangle.NO_BORDER);
                        cellcodigo.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tableCodigo.addCell(cellcodigo);
                        tableCodigo.setWidthPercentage(45);
                        tableCodigo.setHorizontalAlignment(Element.ALIGN_LEFT);
                        document.add(tableCodigo);
                        Paragraph paragraphfechavigencia = new Paragraph();
                        paragraphfechavigencia.add(new Phrase("  Vigencia: Del " + jsonObject.get("fechaventa").getAsString() + " al " + objCaodigoCanje.get("fechafinal").getAsString(), fontText));
                        paragraphfechavigencia.setAlignment(Element.ALIGN_LEFT);
                        paragraphfechavigencia.add(new Phrase(Chunk.NEWLINE));
                        paragraphfechavigencia.add(new Phrase(Chunk.NEWLINE));
                        document.add(paragraphfechavigencia);

                    }
                    Phrase modalidad = new Phrase();
                    modalidad.setFont(fontTitulo);
                    modalidad.add(objProduct.get("modalidad").getAsString());
                    Paragraph textModalidad = new Paragraph();
                    textModalidad.add(new Phrase("  Modalidad de canje: ", fontText));
                    textModalidad.add(modalidad);
                    textModalidad.add(new Phrase(" a través de la app o web de Cineplanet: ", fontText));
                    textModalidad.setAlignment(Element.ALIGN_LEFT);
                    textModalidad.add(new Phrase(Chunk.NEWLINE));
                    textModalidad.add(new Phrase(Chunk.NEWLINE));
                    textModalidad.add(new Phrase(Chunk.NEWLINE));
                    textModalidad.add(new Phrase(Chunk.NEWLINE));
                    document.add(textModalidad);
                    document.add(new Phrase(Chunk.NEWLINE));
                }
            }
            /*=======COMBOS=============================*/
            for (int i = 0; i < arrayProducto.size(); i++) {
                JsonObject objProduct = arrayProducto.get(i).getAsJsonObject();
                if (objProduct.get("tipoProducto").getAsInt() == 2) {
                    Paragraph textNombreCombo = new Paragraph();
                    if (objProduct.get("cantidad").getAsInt() < 10) {
                        textNombreCombo.add(new Phrase(".0" + objProduct.get("cantidad").getAsInt() + " " + objProduct.get("nombreProducto").getAsString(), fontTituloNombre));
                    } else {
                        textNombreCombo.add(new Phrase("." + objProduct.get("cantidad").getAsInt() + " " + objProduct.get("nombreProducto").getAsString(), fontTituloNombre));
                    }
                    textNombreCombo.setAlignment(Element.ALIGN_LEFT);
                    textNombreCombo.add(new Phrase(Chunk.NEWLINE));
                    // textNombreCombo.add(new Phrase(Chunk.NEWLINE));
                    document.add(textNombreCombo);
                    Paragraph paragraphContenido = new Paragraph();
                    paragraphContenido.add(new Phrase(objProduct.get("contenido").getAsString(), fontText));
                    paragraphContenido.setAlignment(Element.ALIGN_LEFT);
                    paragraphContenido.add(new Phrase(Chunk.NEWLINE));
                    paragraphContenido.add(new Phrase(Chunk.NEWLINE));
                    document.add(paragraphContenido);

                    Paragraph paragraphComplejo = new Paragraph();
                    paragraphComplejo.add(new Phrase("  Válidos para: " + objProduct.get("complejos").getAsString(), fontText));
                    paragraphComplejo.setAlignment(Element.ALIGN_LEFT);

                    paragraphComplejo.add(new Phrase(Chunk.NEWLINE));
                    paragraphComplejo.add(new Phrase(Chunk.NEWLINE));
                    document.add(paragraphComplejo);
                    System.out.println("Mi objeto" + objProduct);

                    JsonArray arrayCodigo = objProduct.getAsJsonArray("listaCodigoCanje").getAsJsonArray();
                    System.out.println("Mi array" + arrayCodigo.size());

                    for (int j = 0; j < arrayCodigo.size(); j++) {
                        Paragraph paragraphText = new Paragraph();
                        paragraphText.add(new Phrase("  Código para canje", fontText));
                        paragraphText.setAlignment(Element.ALIGN_LEFT);
                        paragraphText.add(new Phrase(Chunk.NEWLINE));
                        paragraphText.add(new Phrase(Chunk.NEWLINE));
                        document.add(paragraphText);
                        System.out.println("arrayCodigo" + arrayCodigo.get(j));
                        JsonObject objCaodigoCanje = arrayCodigo.get(j).getAsJsonObject();
                        Image img;
                        Barcode128 code = new Barcode128();
                        code.setCode(objCaodigoCanje.get("codigocanje").getAsString());
                        img = code.createImageWithBarcode(pw.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);
                        img.scalePercent(150);
                        PdfPTable tableCodigoBarra = new PdfPTable(1);
                        PdfPCell cellcodigoBarra;
                        cellcodigoBarra = new PdfPCell(img);
                        cellcodigoBarra.setPadding(10);
                        cellcodigoBarra.setCellEvent(new roundCombo());
                        cellcodigoBarra.setBorderColor(new BaseColor(colorpersonalizado));
                        cellcodigoBarra.setBorderWidth(1);
                        cellcodigoBarra.setBorder(Rectangle.NO_BORDER);
                        cellcodigoBarra.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tableCodigoBarra.addCell(cellcodigoBarra);
                        tableCodigoBarra.setWidthPercentage(45);
                        tableCodigoBarra.setHorizontalAlignment(Element.ALIGN_LEFT);
                        document.add(tableCodigoBarra);
                        Paragraph paragraphfechavigencia = new Paragraph();
                        paragraphfechavigencia.add(new Phrase("  Vigencia: Del " + jsonObject.get("fechaventa").getAsString() + " al " + objCaodigoCanje.get("fechafinal").getAsString(), fontText));
                        paragraphfechavigencia.setAlignment(Element.ALIGN_LEFT);
                        paragraphfechavigencia.add(new Phrase(Chunk.NEWLINE));
                        paragraphfechavigencia.add(new Phrase(Chunk.NEWLINE));
                        document.add(paragraphfechavigencia);

                    }
                    Phrase modalidadCombo = new Phrase();
                    modalidadCombo.setFont(fontTitulo);
                    modalidadCombo.add(objProduct.get("modalidad").getAsString());
                    Paragraph textModalidadC = new Paragraph();
                    textModalidadC.add(new Phrase("  Modalidad de canje: ", fontText));
                    textModalidadC.add(modalidadCombo);
                    textModalidadC.add(new Phrase(" en dulcería", fontText));
                    textModalidadC.setAlignment(Element.ALIGN_LEFT);
                    textModalidadC.add(new Phrase(Chunk.NEWLINE));
                    textModalidadC.add(new Phrase(Chunk.NEWLINE));
                    textModalidadC.add(new Phrase(Chunk.NEWLINE));
                    document.add(textModalidadC);
                    document.add(new Phrase(Chunk.NEWLINE));
                }
            }

        } catch (DocumentException documentException) {
            System.out.println("Se ha producido un erro al generar el pdf" + documentException);
        }
        return document;
    }

}
