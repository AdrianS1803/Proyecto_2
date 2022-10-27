package Logica;

<<<<<<< HEAD
import Algoritmos.BubbleSort;
import Algoritmos.QuickSort;
import Algoritmos.RadixSort;
=======
import Algoritmos.QuickSort;
>>>>>>> main
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.LinkedList;

public class Testeos {
    private static LinkedList<Documento> linkedList_documento = new LinkedList<Documento>();

    public static void main(String[] args) throws IOException, InvalidFormatException {

       /*Parse parse = new Parse();
       Documento documento = new Documento();
       documento.setRuta("C:\\Users\\Adrian\\Desktop\\Proyectos\\Proyecto2\\Proyecto_2\\Archivos\\PruebaTxt.txt");
       parse.parseTxt(documento);

       documento.getArbolBinario().inOrden(documento.getArbolBinario().getRoot());*/

        ArrayList<Documento> arrayList = new ArrayList<>();
        Documento documentose = new Documento();
        documentose.setNombre("marco");

        Documento documentosea = new Documento();
        documentosea.setNombre("adria");

<<<<<<< HEAD
        //Parse parse = new Parse();
=======
        Documento documentosear = new Documento();
        documentosear.setNombre("seb");

        arrayList.add(documentose);
        arrayList.add(documentosea);
        arrayList.add(documentosear);

        QuickSort quickSort = new QuickSort();

        quickSort.sort(arrayList);

        for (int i = 0; i<arrayList.size(); i++){
            System.out.println(arrayList.get(i).getNombre());
        }



        /*Parse parse = new Parse();
>>>>>>> main

        File file = new File("C:\\Users\\sebas\\OneDrive\\Escritorio\\TEC\\Semestre 2\\Datos 1\\proyecto2.0\\Proyecto_2\\Archivos\\PruebaDocx.docx");

        Documento documento = new Documento();
        documento.setRuta("C:\\Users\\sebas\\OneDrive\\Escritorio\\TEC\\Semestre 2\\Datos 1\\proyecto2.0\\Proyecto_2\\Archivos\\PruebaDocx.docx");
        //parse.parseDocs(documento);

        BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        documento.setFecha(String.valueOf(attr.creationTime()));


<<<<<<< HEAD
        ////////////////////////////////////////////////////////////////////
        //BubbleSort
        ArrayList<Documento> arrayFechas = new ArrayList<>();

        File doc1 = new File("C:\\Users\\sebas\\OneDrive\\Escritorio\\TEC\\Semestre 2\\Datos 1\\proyecto2.0\\Proyecto_2\\Archivos\\PruebaDocx.docx");
        Documento documento1 = new Documento();
        BasicFileAttributes attr1 = Files.readAttributes(doc1.toPath(), BasicFileAttributes.class);
        documento1.setFecha(String.valueOf(attr1.creationTime().toMillis()/1000));
        arrayFechas.add(documento1);

        File doc2 = new File("C:\\Users\\sebas\\OneDrive\\Escritorio\\TEC\\Semestre 2\\Datos 1\\proyecto2.0\\Proyecto_2\\Archivos\\avion.txt");
        Documento documento2 = new Documento();
        BasicFileAttributes attr2 = Files.readAttributes(doc2.toPath(), BasicFileAttributes.class);
        documento2.setFecha(String.valueOf(attr2.creationTime().toMillis()/1000));
        arrayFechas.add(documento2);

        File doc3 = new File("C:\\Users\\sebas\\OneDrive\\Escritorio\\TEC\\Semestre 2\\Datos 1\\proyecto2.0\\Proyecto_2\\Archivos\\hola.txt");
        Documento documento3 = new Documento();
        BasicFileAttributes attr3 = Files.readAttributes(doc3.toPath(), BasicFileAttributes.class);
        documento3.setFecha(String.valueOf(attr3.creationTime().toMillis()/1000));
        arrayFechas.add(documento3);

        System.out.println("desordenado " +arrayFechas);
        BubbleSort ordenar = new BubbleSort();
        ordenar.BubbleSort(arrayFechas);
        System.out.println("ordenado " +arrayFechas);
        ///////////////////////////////////////////////////////////////////

        ///////////////////////////////////////////////////////////////////
        //QuickSort
        ArrayList<Documento> arrayNombres = new ArrayList<>();

        //File docQuick1 = new File("C:\\Users\\sebas\\OneDrive\\Escritorio\\TEC\\Semestre 2\\Datos 1\\proyecto2.0\\Proyecto_2\\Archivos\\PruebaDocx.docx");
        Documento documentoQuick1 = new Documento();
        //BasicFileAttributes attrQuick1 = Files.readAttributes(doc2.toPath(), BasicFileAttributes.class);
        documentoQuick1.setNombre("hola");
        arrayNombres.add(documentoQuick1);

        Documento documentoQuick2 = new Documento();
        documentoQuick2.setNombre("avioneta");
        arrayNombres.add(documentoQuick2);

        Documento documentoQuick3 = new Documento();
        documentoQuick3.setNombre("parasito");
        arrayNombres.add(documentoQuick3);

        System.out.println("desordenado " +arrayNombres);
        QuickSort ordenarQuick1 = new QuickSort();
        ordenarQuick1.sort(arrayNombres);
        System.out.println("ordenado " + arrayNombres);


        ///////////////////////////////////////////////////////////////
        //radixsort
        ArrayList<Documento> arrayTamano = new ArrayList<>();
        Documento documentoRadix1 = new Documento();
        //BasicFileAttributes attrQuick1 = Files.readAttributes(doc2.toPath(), BasicFileAttributes.class);
        documentoRadix1.setNumero_palabras(4534);
        arrayTamano.add(documentoRadix1);

        Documento documentoRadix2 = new Documento();
        documentoRadix2.setNumero_palabras(40);
        arrayTamano.add(documentoRadix2);

        Documento documentoRadix3 = new Documento();
        documentoRadix3.setNumero_palabras(400);
        arrayTamano.add(documentoRadix3);

        System.out.println("desordenado " +arrayTamano);
        RadixSort radixSort = new RadixSort();
        radixSort.RadixSort(arrayTamano);
        System.out.println("ordenado " + arrayTamano);
=======
        //Convertir numero a fecha

        //documento.getArbolBinario().inOrden(documento.getArbolBinario().getRoot());

        System.out.println(documento.getArbolBinario().search("Prueba"));*/
>>>>>>> main








        /*File ruta = new File("Archivos");

        String[] archives_name = ruta.list();
        LinkedList<Documento> lista_temp = new LinkedList<>();

        for (int i = 0; i < archives_name.length; i++) {

            File file = new File(ruta.getAbsolutePath(), archives_name[i]); //Directorio en el que esta y el nombre del archivo en el que voy en loop

            if (file.isDirectory()) {
                String[] archivos_subcarpeta = file.list();

                for (int j = 0; j < archivos_subcarpeta.length; j++) {
                    File sub_file = new File(file.getAbsolutePath(), archivos_subcarpeta[j]);

                    Documento documento = new Documento();
                    documento.setRuta(sub_file.getAbsolutePath());
                    lista_temp.add(documento);
                }
            } else {
                Documento documento = new Documento();
                documento.setRuta(file.getAbsolutePath());
                lista_temp.add(documento);
            }
        }
        for (int i = 0; i <= lista_temp.size() - 1; i++) {
            System.out.println(lista_temp.get(i).getRuta());
        }

        linkedList_documento = lista_temp;*/
    }
}
