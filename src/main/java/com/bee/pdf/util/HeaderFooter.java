/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.pdf.util;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lealva
 */
public class HeaderFooter extends PdfPageEventHelper {

    Color colorpersonalizado;
    private String nombreempresa;
    private String nombrenegocio;

    public String getNombreempresa() {
        return nombreempresa;
    }

    public void setNombreempresa(String nombreempresa) {
        this.nombreempresa = nombreempresa;
    }

    public String getNombrenegocio() {
        return nombrenegocio;
    }

    public void setNombrenegocio(String nombrenegocio) {
        this.nombrenegocio = nombrenegocio;
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        Image logoEmpresa;
        int widthImg = 0;
        float posicionY = 0;
        URL ubicacionImgEmprea = null;
        URL ubicacionBar = null;
        System.out.println("Empresa" + nombreempresa);
        System.out.println("Negocio" + nombrenegocio);
        try {
            switch (nombreempresa) {
                case "touring":
                    ubicacionImgEmprea = HeaderFooter.class.getResource("/img/logoBig.jpg");
                    widthImg = 100;
                    posicionY = 460f;
                    break;
                case "scotiabank":
                    ubicacionImgEmprea = HeaderFooter.class.getResource("/img/logoScotiabank.png");
                    widthImg = 100;
                    break;
                case "atwork":
                    ubicacionImgEmprea = HeaderFooter.class.getResource("/img/logo-bee.png");
                    widthImg = 100;
                    break;
            }
            switch (nombrenegocio) {
                case "benefit":
                    ubicacionBar = HeaderFooter.class.getResource("/img/bar.png");
                    colorpersonalizado = new Color(0, 24, 73);
                    break;
                case "promo":
                    ubicacionBar = HeaderFooter.class.getResource("/img/barPromo.png");
                    colorpersonalizado = new Color(0, 24, 73);
                    break;
                case "plataforma":
                    ubicacionBar = HeaderFooter.class.getResource("/img/bar.png");
                    colorpersonalizado = new Color(0, 24, 73);
                    break;
            }
            logoEmpresa = Image.getInstance((ubicacionImgEmprea));
            logoEmpresa.scaleAbsoluteWidth(widthImg);
            logoEmpresa.scaleAbsoluteHeight(80);
            logoEmpresa.setAbsolutePosition(460f, 730f);
            document.add(logoEmpresa);
            Image imgPiePagina = Image.getInstance(ubicacionBar);
            imgPiePagina.setAbsolutePosition(520f, 0f);
            imgPiePagina.scaleAbsoluteHeight(350);
            document.add(imgPiePagina);
            // document.add(logoEmpresa);
        } catch (IOException exception) {
            System.out.println("Execpcion " + exception);
        } catch (BadElementException ex) {
            Logger.getLogger(HeaderFooter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(HeaderFooter.class.getName()).log(Level.SEVERE, null, ex);
        }
        addHeader(writer);
        addFooter(writer);
    }

    private void addHeader(PdfWriter writer) {
        BaseFont baseFont = null;
        try {
            baseFont = BaseFont.createFont(GenerarPdf.class.getResource("/estilos/TTNorms-Bold.otf").toString(), "Cp1252", true);
        } catch (DocumentException ex) {
            Logger.getLogger(GenerarPdf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenerarPdf.class.getName()).log(Level.SEVERE, null, ex);
        }
        URL ubicacionImgNegocio = null;
        Image logoNegocio = null;
        try {
            /*LOGO DE NEGOCIO*/
            try {

                switch (nombrenegocio) {
                    case "benefit":
                        ubicacionImgNegocio = HeaderFooter.class.getResource("/img/Grupo 1333.png");
                        colorpersonalizado = new Color(0, 24, 73);
                        break;
                    case "promo":
                        ubicacionImgNegocio = HeaderFooter.class.getResource("/img/CinePromo.png");
                        colorpersonalizado = new Color(0, 24, 73);
                        break;
                    case "plataforma":
                        ubicacionImgNegocio = HeaderFooter.class.getResource("/img/logo.png");
                        colorpersonalizado = new Color(0, 24, 73);
                        break;
                }
                logoNegocio = Image.getInstance(ubicacionImgNegocio);
                logoNegocio.scaleToFit(300, 300);
            } catch (IOException exception) {
                System.out.println("Execpcion " + exception);
            }
            /*DECLARACION DE TABLA*/
            PdfPTable table = new PdfPTable(1);
            float[] medidaCeldas = {10.75f};
            table.setWidths(medidaCeldas);
            /*LOGO DEL NEGOCIO*/
            PdfPCell cellLogoNegocio;
            cellLogoNegocio = new PdfPCell(logoNegocio);
            cellLogoNegocio.setBorder(0);
            table.addCell(cellLogoNegocio);
            /*CELDA VACIA PARA EL ESPACIO*/
            PdfPCell cellVacio = new PdfPCell(new Phrase(Chunk.NEWLINE));
            cellVacio.setBorder(0);
            table.addCell(cellVacio);
            /*CELDA CON EL TITULO*/
            PdfPCell cellTitulo;
            Paragraph paragraph = new Paragraph();
            Font fontTitulo = new Font(baseFont, 15, Font.NORMAL, new BaseColor(colorpersonalizado));
            paragraph.add(new Phrase("Cupones de compra", fontTitulo));
            paragraph.setAlignment(Element.ALIGN_LEFT);
            paragraph.add(new Phrase(Chunk.NEWLINE));
            paragraph.add(new Phrase(Chunk.NEWLINE));
            cellTitulo = new PdfPCell(paragraph);
            cellTitulo.setBorder(0);
            table.addCell(cellTitulo);
            /*AGREGAMOS LA TABLA*/
            PdfPCell cell = new PdfPCell();
            cell.setBorder(Rectangle.BOTTOM);
            cell.setBorderColor(new BaseColor(colorpersonalizado));
            table.addCell(cell);
            table.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.setTotalWidth(530);
            table.setLockedWidth(true);
            table.writeSelectedRows(0, -1, 30, 803, writer.getDirectContent());

        } catch (DocumentException de) {
            throw new ExceptionConverter(de);
        }
    }

    private void addFooter(PdfWriter writer) {
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
        switch (nombrenegocio) {
            case "benefit":
                colorpersonalizado = new Color(0, 24, 73);
                break;
            case "promo":
                colorpersonalizado = new Color(0, 24, 73);
                break;
            case "plataforma":
                colorpersonalizado = new Color(0, 24, 73);
                break;
        }
        PdfPTable footer = new PdfPTable(1);
        PdfPCell cell = new PdfPCell();
        cell.setBorder(Rectangle.TOP);
        cell.setBorderColor(new BaseColor(colorpersonalizado));
        footer.addCell(cell);
        Font fontTituloTerminos = new Font(baseFontBold, 13, Font.NORMAL, new BaseColor(colorpersonalizado));
        Font fontTextTermino = new Font(baseFontRegular, 10, Font.NORMAL, new BaseColor(colorpersonalizado));
        Font fontTextTerminoN = new Font(baseFontBold, 10, Font.NORMAL, new BaseColor(colorpersonalizado));
        Paragraph textTituloTermino = new Paragraph();
        textTituloTermino.add(new Phrase("TÉRMINOS Y CONDICIONES:", fontTituloTerminos));
        textTituloTermino.setAlignment(Element.ALIGN_LEFT);
        textTituloTermino.add(new Phrase(Chunk.NEWLINE));
        textTituloTermino.add(new Phrase(Chunk.NEWLINE));
        PdfPCell celTitulo = new PdfPCell(textTituloTermino);
        celTitulo.setBorder(0);
        footer.addCell(celTitulo);
        /*LISTADO DE TERMINOS Y CONDICIONES*/
        Phrase termino1 = new Phrase();
        termino1.setFont(fontTextTermino);
        termino1.add(".No se aceptan cambios ni devoluciones una vez entregado el boleto.");
        PdfPCell Celltermino1 = new PdfPCell(termino1);
        Celltermino1.setBorder(0);
        footer.addCell(Celltermino1);
        Phrase termino2 = new Phrase();
        termino2.setFont(fontTextTermino);
        termino2.add(".Prohibida su reventa y/o reproducción.");
        PdfPCell Celltermino2 = new PdfPCell(termino2);
        Celltermino2.setBorder(0);
        footer.addCell(Celltermino2);
        Phrase termino3 = new Phrase();
        termino3.setFont(fontTextTermino);
        termino3.add(".No renovable ni ampliable por vencimiento.");
        PdfPCell Celltermino3 = new PdfPCell(termino3);
        Celltermino3.setBorder(0);
        footer.addCell(Celltermino3);
        Phrase termino4 = new Phrase();
        termino4.setFont(fontTextTermino);
        termino4.add(".El cliente es responsable del uso y manipulación del presente boleto.");
        PdfPCell Celltermino4 = new PdfPCell(termino4);
        Celltermino4.setBorder(0);
        footer.addCell(Celltermino4);
        Phrase termino5N = new Phrase();
        termino5N.setFont(fontTextTerminoN);
        termino5N.add("Prime");
        Phrase termino5 = new Phrase();
        termino5.setFont(fontTextTermino);
        termino5.add(".Los boletos para canje no son válidos para la primera semana de estreno (a excepción de los boletos Prime sin restricción), salas 3D y/o restricciones indicadas por la casa distribuidora.");
        /* termino5.add(termino5N);
         termino5.add(").");*/
        PdfPCell Celltermino5 = new PdfPCell(termino5);
        Celltermino5.setBorder(0);
        footer.addCell(Celltermino5);
        /* Phrase termino6 = new Phrase();
         termino6.setFont(fontTextTermino);
         termino6.add(".No válido en salas 3D");
         PdfPCell Celltermino6 = new PdfPCell(termino6);
         Celltermino6.setBorder(0);
         footer.addCell(Celltermino6);*/
        Phrase termino7 = new Phrase();
        termino7.setFont(fontTextTermino);
        termino7.add(".Válido para acumular puntos y visitas como Socio Cineplanet.");
        PdfPCell Celltermino7 = new PdfPCell(termino7);
        Celltermino7.setBorder(0);
        footer.addCell(Celltermino7);
        Phrase termino8 = new Phrase();
        termino8.setFont(fontTextTermino);
        termino8.add(".No se aceptan cambios ni devoluciones una vez entregado el boleto.");
        PdfPCell Celltermino8 = new PdfPCell(termino8);
        Celltermino8.setBorder(0);
        footer.addCell(Celltermino8);
        Phrase termino9Telefono = new Phrase();
        termino9Telefono.setFont(fontTextTerminoN);
        termino9Telefono.add("624-9500");
        Phrase termino9Correo = new Phrase();
        termino9Correo.setFont(fontTextTerminoN);
        termino9Correo.add("contactanos@cineplanet.com.pe");
        Phrase termino9 = new Phrase();
        termino9.setFont(fontTextTermino);
        termino9.add(".Cualquier consulta sírvase realizarlo directamente a través de ALO PLANET: ");
        termino9.add(termino9Telefono);
        termino9.add(" o al correo: ");
        termino9.add(termino9Correo);
        PdfPCell Celltermino9 = new PdfPCell(termino9);
        Celltermino9.setBorder(0);
        footer.addCell(Celltermino9);
        footer.setTotalWidth(450);
        footer.setLockedWidth(true);
        footer.writeSelectedRows(0, -1, 34, 220, writer.getDirectContent());
    }
}
