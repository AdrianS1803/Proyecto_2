package Logica;

import Algoritmos.BubbleSort;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class Testeos {
    private static LinkedList<Documento> linkedList_documento = new LinkedList<Documento>();

    public static void main(String[] args) throws IOException, InvalidFormatException {

       /*Parse parse = new Parse();
       Documento documento = new Documento();
       documento.setRuta("C:\\Users\\Adrian\\Desktop\\Proyectos\\Proyecto2\\Proyecto_2\\Archivos\\PruebaTxt.txt");
       parse.parseTxt(documento);

       documento.getArbolBinario().inOrden(documento.getArbolBinario().getRoot());*/



        Parse parse = new Parse();

        File file = new File("C:\\Users\\sebas\\OneDrive\\Escritorio\\TEC\\Semestre 2\\Datos 1\\proyecto2.0\\Proyecto_2\\Archivos\\PruebaDocx.docx");

        Documento documento = new Documento();
        documento.setRuta("C:\\Users\\sebas\\OneDrive\\Escritorio\\TEC\\Semestre 2\\Datos 1\\proyecto2.0\\Proyecto_2\\Archivos\\PruebaDocx.docx");
        parse.parseDocs(documento);

        BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        documento.setFecha(String.valueOf(attr.creationTime()));

        System.out.println(documento.getFecha());
        DateFormat prueba = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String xd = prueba.format(date).toString();
        System.out.println(xd);
        Long fechaint = Long.valueOf(xd);
        System.out.println(fechaint);
        Long asd = Long.valueOf("11115500776655");
        Long asdas = Long.valueOf("44445500776655");

        BubbleSort ordenar = new BubbleSort();
        Long arrayPrueba[] = {fechaint, asdas, asd};
        ordenar.BubbleSort(arrayPrueba);
        ordenar.mostrar(arrayPrueba);
        //Convertir numero a fecha

        //documento.getArbolBinario().inOrden(documento.getArbolBinario().getRoot());

        System.out.println(documento.getArbolBinario().search("Prueba"));








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
