package Algoritmos;

import ArbolBinario.AVL_Nodo_new;
import ArbolBinario.AVL_new;
import ArbolBinario.ArbolBinario;
import Logica.Documento;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class testAVl {
    public static void main(String[] args) throws FileNotFoundException {
        AVL_new avl_new = new AVL_new();
        Documento documento = new Documento();


        File file = new File("C:\\Users\\Adrian\\Desktop\\Proyectos\\Proyecto2\\Proyecto_2\\Archivos\\PruebaTxt.txt");
        int numero_palabras = 0;

        Scanner scanner = new Scanner(file);



        while (scanner.hasNext()){
            String palabra = scanner.next();
            palabra = palabra.toLowerCase();


            avl_new.insertar(palabra);


            numero_palabras++;
        }


        scanner.close();
        //------------------------

        documento.setAvl_new(avl_new);

        //--------------------------------

        String dato = avl_new.obtenerRaiz().hijoIzquierdo.dato;
       // System.out.println(dato);

        System.out.println((documento.getAvl_new().buscar("txt", documento.getAvl_new().obtenerRaiz())).dato);
        //System.out.println("aa "+ documento.getAvl_new().obtenerRaiz().dato);
        //System.out.println(avl_new.buscar("txt", avl_new.obtenerRaiz()));



       /*AVL_new arbol = new AVL_new();
       arbol.insertar("sebas");
       arbol.insertar("adrian");
       arbol.insertar("juan");
       arbol.insertar("ramon");
       arbol.insertar("marco");
        arbol.insertar("babo");
        arbol.insertar("cortes");
        arbol.insertar("lolo");


        arbol.inOrder(arbol.obtenerRaiz());

        System.out.println(arbol.buscar("lolo", arbol.obtenerRaiz()));


        arbol.setComparacionesArbol(arbol.buscar("lolo", arbol.obtenerRaiz()).getComparaciones());
        System.out.println(arbol.getComparaciones());

        arbol.setComparacionesArbol(0);


        arbol.setComparacionesArbol(arbol.buscar("juan", arbol.obtenerRaiz()).getComparaciones());
        System.out.println(arbol.getComparaciones());
    }
    public static String comparaPalabra(String palabra1, String palabra2){
        int resultado = palabra1.compareTo(palabra2);

        String palabra_resultado = null;
        if (resultado>0){
            palabra_resultado = palabra2;
        } else if (resultado<0) {
            palabra_resultado = palabra1;
        }else if (resultado==0){
            palabra_resultado = "misma palabra";
        }
        return palabra_resultado;*/
    }
}
