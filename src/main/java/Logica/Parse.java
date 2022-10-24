package Logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

import ArbolBinario.ArbolBinario;
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

            //----------------------Voy por aqui en las pruebas
        }else if (getFileExtension(file).equals(".pdf")){
            //mensaje = parsePdf(file);
        }else if (getFileExtension(file).equals(".docs")){
            parseDocs(documento);

        }else {
            System.out.println("Error en parse document");
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
    public String parsePdf(File file){
        //NO SE PORQUE NO FUNCIONA

        /*// Create a content handler
        BodyContentHandler contenthandler = new BodyContentHandler();

        // Create a file in local directory
        File f = new File("C:\\Users\\Adrian\\Desktop\\Proyectos\\Proyecto2\\Proyecto_2\\Archivos\\PruebaPDF.pdf");

        // Create a file input stream
        // on specified path with the created file
        FileInputStream fstream = new FileInputStream(f);

        // Create an object of type Metadata to use
        Metadata data = new Metadata();

        // Create a context parser for the pdf document
        ParseContext context = new ParseContext();

        // PDF document can be parsed using the PDFparser
        // class
        PDFParser pdfparser = new PDFParser();

        // Method parse invoked on PDFParser class
        try {
            pdfparser.parse(fstream, contenthandler, data,
                    context);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (TikaException e) {
            throw new RuntimeException(e);
        }


        // Printing the contents of the pdf document
        // using toString() method in java
        System.out.println("Extracting contents :"
                + contenthandler.toString());*/

        return file.getAbsolutePath();
    }
    public void parseDocs(Documento documento) throws IOException, InvalidFormatException {
        //ERROR StatusLogger Log4j2 could not find a logging implementation. Please add log4j-core to the classpath. Using SimpleLogger to log to the console...
        File file = new File(documento.getRuta());

        XWPFDocument docx = new XWPFDocument(OPCPackage.open(file));
        XWPFWordExtractor wordExtractor = new XWPFWordExtractor(docx);
        System.out.println(wordExtractor.getText());

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
