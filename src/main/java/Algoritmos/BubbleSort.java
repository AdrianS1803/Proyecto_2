package Algoritmos;

import Logica.Documento;

import java.util.ArrayList;

/**
 *@author Sebastían Hernández Bonilla y Adrián Salas Solís
 *@version v0.1 octubre 2022
 */
public class BubbleSort {
    private int i;
    private int j;
    private Documento ordenador;

    /**
     * Constructor de la clase BubbleSort.
     */
    public BubbleSort(){}

    /**
     * Metodo de ordenamiento BubbleSort.
     * @param array ArrayList<Documento> es el arraylist de documentos que recibe para ordenarlos en orden de fecha.
     */
    public ArrayList<Documento> sort(ArrayList<Documento> array){

        for(i = 0; i < array.size(); i++){
            for(j = i+1; j < array.size(); j++){
                if(Integer.parseInt(array.get(i).getFecha()) > Integer.parseInt(array.get(j).getFecha())){
                    ordenador = array.get(i);
                    array.set(i, array.get(j));
                    array.set(j, ordenador);
                }
            }
    }
        return array;
    }
}
