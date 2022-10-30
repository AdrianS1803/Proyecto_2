package Algoritmos;

import ArbolBinario.AVL_Nodo_new;
import ArbolBinario.AVL_new;

public class testAVl {
    public static void main(String[] args){
       AVL_new arbol = new AVL_new();
       arbol.insertar("sebas");
       arbol.insertar("adrian");
       arbol.insertar("juan");
       arbol.insertar("ramon");
       arbol.insertar("marco");
        arbol.insertar("babo");
        arbol.insertar("cortes");
        arbol.insertar("lolo");
        /*arbol.insertar(13);
        arbol.insertar(1);
        arbol.insertar(6);
        arbol.insertar(17);
        arbol.insertar(16);*/
        //arbol.preOrden(arbol.obtenerRaiz());

        //arbol.inOrder(arbol.obtenerRaiz());
        arbol.buscar("juja", arbol.obtenerRaiz());
        //System.out.println(arbol.buscar("marco",arbol.obtenerRaiz()).getComparaciones());

        AVL_Nodo_new avl_nodo_new = arbol.buscar("babo",arbol.obtenerRaiz());
        int comparaciones = avl_nodo_new.comparaciones;
        System.out.println(comparaciones);



        //System.out.println("\n");





        /*String palabra1 = "ave";
        String palabra2 = "zorro";
        System.out.println(palabra1.compareTo(palabra2));*/

        //System.out.println(comparaPalabra(palabra1, palabra2));

       /* AVL_new avl_new = new AVL_new();

        avl_new.insertar(1);

        System.out.println(avl_new.buscar(1, avl_new.obtenerRaiz()).dato);*/


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
        return palabra_resultado;
    }
}
