package Logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

import ArbolBinario.ArbolBinario;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.xml.sax.SAXException;

public class Parse {
    public Parse (){}

    public void parseDocument(Documento documento) throws IOException, InvalidFormatException {
        File file = new File(documento.getRuta());
        if (getFileExtension(file).equals(".txt")){
             parseTxt(documento);
            System.out.println("Se logro parsear txt de " + documento.getNombre());

        }else if (getFileExtension(file).equals(".pdf")){
            parsePdf(documento);
            System.out.println("Se logro parsear pdf de " + documento.getNombre());

        }else if (getFileExtension(file).equals(".docx")){
            parseDocs(documento);
            System.out.println("Se logro parsear docs de " + documento.getNombre());

        }else {
            System.out.println("Error en parse document de " + documento.getNombre());
        }

    }
    public void parseTxt(Documento documento) throws IOException {
        ArbolBinario arbolBinario = new ArbolBinario();
        File file = new File(documento.getRuta());
        int numero_palabras = 0;

        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()){
            arbolBinario.insertNode(scanner.next());

            numero_palabras++;
        }
        scanner.close();

        documento.setArbolBinario(arbolBinario);
        documento.setNumero_palabras(numero_palabras);

    }
    public void parsePdf(Documento documento) throws IOException {
        ArbolBinario arbolBinario = new ArbolBinario();
        int numero_palabras = 0;

        File file = new File(documento.getRuta());
        FileInputStream fileInputStream = new FileInputStream(file);
        PDDocument pdDocument = PDDocument.load(fileInputStream);
        PDFTextStripper pdfTextStripper = new PDFTextStripper();

        String alldoc = pdfTextStripper.getText(pdDocument);

        Scanner scanner = new Scanner(alldoc);

        while (scanner.hasNext()){
            arbolBinario.insertNode(scanner.next());

            numero_palabras++;
        }
        scanner.close();

        documento.setArbolBinario(arbolBinario);
        documento.setNumero_palabras(numero_palabras);

    }
    public void parseDocs(Documento documento) throws IOException, InvalidFormatException {
        //ERROR StatusLogger Log4j2 could not find a logging implementation. Please add log4j-core to the classpath. Using SimpleLogger to log to the console...
        File file = new File(documento.getRuta());

        XWPFDocument docx = new XWPFDocument(OPCPackage.open(file));
        XWPFWordExtractor wordExtractor = new XWPFWordExtractor(docx);

        //-----
        ArbolBinario arbolBinario = new ArbolBinario();
        int numero_palabras = 0;

        Scanner scanner = new Scanner(wordExtractor.getText());

        while (scanner.hasNext()){
            arbolBinario.insertNode(scanner.next());

            numero_palabras++;
        }
        scanner.close();

        documento.setArbolBinario(arbolBinario);
        documento.setNumero_palabras(numero_palabras);
        //-------------
    }

    private String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        return name.substring(lastIndexOf);
    }
}
