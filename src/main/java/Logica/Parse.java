package Logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.xml.sax.SAXException;

public class Parse {
    public Parse (){}

    public Documento parseDocument(File file, String searching) throws IOException, InvalidFormatException {
        Documento documento = new Documento();
        if (getFileExtension(file).equals(".txt")){
             parseTxt(file, searching);


            //----------------------Voy por aqui en las pruebas
        }else if (getFileExtension(file).equals(".pdf")){
            //mensaje = parsePdf(file);
        }else if (getFileExtension(file).equals(".docs")){
            //mensaje = parseDocs(file);
        }else {
            System.out.println("Error en parse document");
        }
        return documento;
    }
    public Documento parseTxt(File file, String searching) throws IOException {
        int numero_palabras = 0;
        Documento documento = new Documento();
        String mensaje = "-";
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()){
            if (searching.equals(String.valueOf(scanner.next()))){
                //Aqui seria lo del arbol
                mensaje = "Encontrada";
                break;
            }else {
                mensaje = "No encontrada";
            }
            numero_palabras++;
        }
        scanner.close();

        documento.setNombre(file.getName());

        BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);

        documento.setFecha(String.valueOf(attr.creationTime()));
        documento.setNumero_palabras(numero_palabras);

        return documento;
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
    public String parseDocs(File file) throws IOException, InvalidFormatException {
        XWPFDocument docx = new XWPFDocument(OPCPackage.open(file));
        XWPFWordExtractor wordExtractor = new XWPFWordExtractor(docx);
        System.out.println(wordExtractor.getText());

        return file.getAbsolutePath();
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
