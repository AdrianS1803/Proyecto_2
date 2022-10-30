package Logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import ArbolBinario.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;


/**
 *@author Sebastían Hernández Bonilla y Adrián Salas Solís
 *@version v0.1 octubre 2022
 */
public class Parse {
    /**
     * Constuctor del obejeto Parse.
     */
    public Parse (){}

    /**
     * Recibe un documento y analiza su tipo de archivo, si es docx, pdf o txt llama al parse especifico, sino no realiza nada sobre el documento.
     * @param documento Documento es el documento que recibe.
     * @throws IOException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws InvalidFormatException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
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

    /**
     * Parsea un archivo txt y genera un árbolBinaro y un Avl.
     * @param documento Documento que recibe.
     * @throws IOException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
    public void parseTxt(Documento documento) throws IOException {
        ArbolBinario arbolBinario = new ArbolBinario();
        AVL_new avl_new = new AVL_new();

        LinkedList<String> listaPalbra = new LinkedList<>();

        File file = new File(documento.getRuta());
        int numero_palabras = 0;

        Scanner scanner = new Scanner(file);



        while (scanner.hasNext()){
            String palabra = scanner.next();
            listaPalbra.add(palabra);


            arbolBinario.insertNode(palabra);




            avl_new.insertar(palabra);
            //System.out.println(palabra);

            numero_palabras++;
        }


        generaPalabras(listaPalbra, arbolBinario);


        scanner.close();
        //------------------------
        documento.setArbolBinario(arbolBinario);
        documento.setAvl_new(avl_new);
        documento.setNumero_palabras(numero_palabras);
        //--------------------------------
    }

    /**
     * Parsea un archivo pdf y genera un árbolBinaro y un Avl.
     * @param documento Documento que recibe
     * @throws IOException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
    public void parsePdf(Documento documento) throws IOException {
        ArbolBinario arbolBinario = new ArbolBinario();
        int numero_palabras = 0;
        AVL_new avl_new = new AVL_new();

        LinkedList<String> listaPalbra = new LinkedList<>();

        File file = new File(documento.getRuta());
        FileInputStream fileInputStream = new FileInputStream(file);
        PDDocument pdDocument = PDDocument.load(fileInputStream);
        PDFTextStripper pdfTextStripper = new PDFTextStripper();

        String alldoc = pdfTextStripper.getText(pdDocument);

        Scanner scanner = new Scanner(alldoc);

        while (scanner.hasNext()){
            String palabra = scanner.next();

            listaPalbra.add(palabra);

            arbolBinario.insertNode(palabra);
            avl_new.insertar(palabra);


            numero_palabras++;
        }

        generaPalabras(listaPalbra, arbolBinario);

        scanner.close();
        //--------------
        documento.setArbolBinario(arbolBinario);
        documento.setAvl_new(avl_new);
        documento.setNumero_palabras(numero_palabras);
        //--------------------
    }

    /**
     * Parsea un archivo docx y genera un árbolBinaro y un Avl.
     * @param documento Documento que recibe
     * @throws IOException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws InvalidFormatException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
    public void parseDocs(Documento documento) throws IOException, InvalidFormatException {
        //ERROR StatusLogger Log4j2 could not find a logging implementation. Please add log4j-core to the classpath. Using SimpleLogger to log to the console...
        File file = new File(documento.getRuta());
        AVL_new avl_new = new AVL_new();
        XWPFDocument docx = new XWPFDocument(OPCPackage.open(file));
        XWPFWordExtractor wordExtractor = new XWPFWordExtractor(docx);

        //-----
        ArbolBinario arbolBinario = new ArbolBinario();
        int numero_palabras = 0;

        LinkedList<String> listaPalbra = new LinkedList<>();

        Scanner scanner = new Scanner(wordExtractor.getText());

        while (scanner.hasNext()){
            String palabra = scanner.next();

            listaPalbra.add(palabra);

            arbolBinario.insertNode(palabra);
            avl_new.insertar(palabra);

        }

        generaPalabras(listaPalbra, arbolBinario);

        scanner.close();
        //-----------------
        documento.setArbolBinario(arbolBinario);
        documento.setAvl_new(avl_new);
        documento.setNumero_palabras(numero_palabras);
        //-------------
    }

    /**
     * Obtiene la extensión de un archivo.
     * @param file File es el file que recibe.
     * @return String es la extension del archivo.
     */
    private String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        return name.substring(lastIndexOf);
    }
    private void generaPalabras(LinkedList<String> listaPalbra, ArbolBinario arbolBinario){
        for (int i = 0; i<=listaPalbra.size()-1; i++){


            if (listaPalbra.size() == 1 ){

                arbolBinario.search(listaPalbra.get(i)).setFrase(new String[]{""," " + listaPalbra.get(i),""});
            } else if (listaPalbra.size() == 2){

                if (i == 0)
                    arbolBinario.search(listaPalbra.get(i)).setFrase(new String[]{""," " + listaPalbra.get(i)," " +listaPalbra.get(i+1)});
                else
                    arbolBinario.search(listaPalbra.get(i)).setFrase(new String[]{listaPalbra.get(i-1)," " + listaPalbra.get(i),""});
            } else if (listaPalbra.size() == 3){
                if (i == 0)
                    arbolBinario.search(listaPalbra.get(i)).setFrase(new String[]{"", " " + listaPalbra.get(i), " " + listaPalbra.get(i+1) + " "+listaPalbra.get(i+2)});
                else if (i == 1)
                    arbolBinario.search(listaPalbra.get(i)).setFrase(new String[]{"" + listaPalbra.get(i-1), " " + listaPalbra.get(i), " " + listaPalbra.get(i+1) + " " });
                else if (i == 2)
                    arbolBinario.search(listaPalbra.get(i)).setFrase(new String[]{"" + listaPalbra.get(i-1) + " "+listaPalbra.get(i-2), " " + listaPalbra.get(i), " " });
            } else if (listaPalbra.size() == 4) {
                if (i == 0)
                    arbolBinario.search(listaPalbra.get(i)).setFrase(new String[]{"", " " + listaPalbra.get(i), " " + listaPalbra.get(i+1) + " "+listaPalbra.get(i+2) + listaPalbra.get(i+3)});
                else if (i == 1)
                    arbolBinario.search(listaPalbra.get(i)).setFrase(new String[]{""+listaPalbra.get(i-1), " "+listaPalbra.get(i)  ," "+listaPalbra.get(i+1)+ " " + listaPalbra.get(i+2)});
                else if (i == 2)
                    arbolBinario.search(listaPalbra.get(i)).setFrase(new String[]{""+listaPalbra.get(i-1)+" "+listaPalbra.get(i-2), " " + listaPalbra.get(i), " "+listaPalbra.get(i+1) });
                else if (i == 3)
                    arbolBinario.search(listaPalbra.get(i)).setFrase(new String[]{""+listaPalbra.get(i-1)+" "+listaPalbra.get(i-2) + " "+ listaPalbra.get(i-3), " " + listaPalbra.get(i), ""});

            } else
            if (i == 0)
                arbolBinario.search(listaPalbra.get(i)).setFrase(new String[]{"", " " + listaPalbra.get(i), " " + listaPalbra.get(i+1) + " "+listaPalbra.get(i+2) + listaPalbra.get(i+3)});
            else if (i == 1)
                arbolBinario.search(listaPalbra.get(i)).setFrase(new String[]{""+listaPalbra.get(i-1), " "+listaPalbra.get(i)  ," "+listaPalbra.get(i+1)+ " " + listaPalbra.get(i+2)});
            else if (i == 2)
                arbolBinario.search(listaPalbra.get(i)).setFrase(new String[]{""+listaPalbra.get(i-2)+" "+listaPalbra.get(i-1), " "+listaPalbra.get(i)  ," "+listaPalbra.get(i+1)+ " " + listaPalbra.get(i+2)});

            else if (i == listaPalbra.size()-1)
                arbolBinario.search(listaPalbra.get(i)).setFrase(new String[]{""+listaPalbra.get(i-3)+" "+listaPalbra.get(i-2)+" "+listaPalbra.get(i-1)," "+listaPalbra.get(i)," "+listaPalbra.get(i+1)});
            else if(i == listaPalbra.size())
                arbolBinario.search(listaPalbra.get(i)).setFrase(new String[]{""+listaPalbra.get(i-4)+" "+listaPalbra.get(i-3)+ " "+listaPalbra.get(i-2)+" "+listaPalbra.get(i-1)," "+listaPalbra.get(i),""});
            else
                arbolBinario.search(listaPalbra.get(i)).setFrase(new String[]{""+listaPalbra.get(i-2) +" "+listaPalbra.get(i-1)," "+listaPalbra.get(i)," "+listaPalbra.get(i+1)+" "+listaPalbra.get(i+2)});


        }
    }
}
