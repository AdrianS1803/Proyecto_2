package Logica;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.*;
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
        Documento documento = new Documento();
        documento.setRuta("C:\\Users\\Adrian\\Desktop\\Proyectos\\Proyecto2\\Proyecto_2\\Archivos\\PruebaDocx.docx");
        parse.parseDocs(documento);

        documento.getArbolBinario().inOrden(documento.getArbolBinario().getRoot());








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
