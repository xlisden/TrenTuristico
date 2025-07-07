package com.example.demo.Service;
import com.example.demo.Entity.dto.EstacionDto;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.*;
import com.itextpdf.layout.element.*;

import java.io.File;
import java.io.FileOutputStream;

public class GenerarPDF {
    public void crearPDF(EstacionDto esta) throws Exception {
        PdfWriter writer = new PdfWriter(new FileOutputStream("persona.pdf"));
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        document.add(new Paragraph("INFORME DE PERSONA"));
        document.add(new Paragraph("Nombre: " + esta.getNombre()));
        document.add(new Paragraph("DNI: " + esta.getTemperatura()));
        document.add(new Paragraph("Edad: " + esta.getNroZonasTuristicas()));

        document.close();
    }
}
