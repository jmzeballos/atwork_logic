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

/**
 *
 * @author Lealva
 */
public class roudTotales implements PdfPCellEvent{

    @Override
    public void cellLayout(PdfPCell ppc, Rectangle rctngl, PdfContentByte[] pcbs) {
      PdfContentByte cb = pcbs[PdfPTable.LINECANVAS];
        cb.setColorStroke(BaseColor.BLACK); 
        cb.roundRectangle(
            rctngl.getLeft(), rctngl.getBottom(), rctngl.getWidth() ,
            13, 0);    
        cb.stroke();
    }
    
}
