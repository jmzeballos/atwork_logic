/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.pdf.util;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPCellEvent;
import com.itextpdf.text.pdf.PdfPTable;
import java.awt.Color;

/**
 *
 * @author Lealva
 */
public class round implements PdfPCellEvent{
Color colorpersonalizado = new Color(0, 24, 73);
    public void cellLayout(PdfPCell cell, Rectangle rect,
            PdfContentByte[] canvas) {
        PdfContentByte cb = canvas[PdfPTable.LINECANVAS];
        cb.setColorStroke(new BaseColor(colorpersonalizado)); 
        cb.roundRectangle(
            rect.getLeft() + 1.5f, rect.getBottom() + 1.5f, rect.getWidth() - 3,
            rect.getHeight() +2, 15);
    
        cb.stroke();
    }

}
