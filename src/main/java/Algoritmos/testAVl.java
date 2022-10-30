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
       System.out.println(arbol);


        arbol.inOrder(arbol.obtenerRaiz());
        arbol.setComparacionesArbol(arbol.buscar("lolo", arbol.obtenerRaiz()).getComparaciones());
        System.out.println(arbol.getComparaciones());
        arbol.setComparacionesArbol(0);//ACORDARSE DE PONER ESTO!!!!!!!!!!!!!!!!
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
        return palabra_resultado;
    }
}
