package Algoritmos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class testquick {
    public static void main(String args[]) throws IOException {
        File file = new File("C:\\Users\\Adrian\\Desktop\\Proyectos\\Proyecto2\\Proyecto_2\\Archivos\\PruebaPDF.pdf");
        FileInputStream fileInputStream = new FileInputStream(file);
        PDDocument pdDocument = PDDocument.load(fileInputStream);
        PDFTextStripper pdfTextStripper = new PDFTextStripper();

        String alldoc = pdfTextStripper.getText(pdDocument);

        System.out.println(alldoc);
    }
}
