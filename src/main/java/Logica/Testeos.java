package Logica;

import java.io.File;
import java.io.FileNotFoundException;

public class Testeos {
    public static void main(String[] args) throws FileNotFoundException {
        Parse parse = new Parse();
        System.out.println(parse.parseTxt(new File("C:\\Users\\Adrian\\Desktop\\Proyectos\\Proyecto2\\Proyecto_2\\Archivos\\PruebaTxt.txt"),"mario"));
    }
}
