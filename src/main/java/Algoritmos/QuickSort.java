//https://www.lawebdelprogramador.com/foros/Java/1731852-Como-puedo-usar-Quicksort-para-ordenar-nombres-alfabeticamente.html
package Algoritmos;

import Logica.Documento;

import java.util.ArrayList;

/**
 *@author Sebastían Hernández Bonilla y Adrián Salas Solís
 *@version v0.1 octubre 2022
 */
public class QuickSort {

    private ArrayList<Documento> input;
    private int size;

    /**
     * Constructor de la clase QuickSort.
     */
    public QuickSort(){}

    /**
     * Metodo de llamado al QuickSort.
     * @param names ArrayList<Documento> es el arraylist de documentos que recibe para ordenarlos en orden de nombre alfabéticamente.
     * @return ArrayList returna el arraylist ordenado por nombres.
     */
    public ArrayList<Documento> sort(ArrayList<Documento> names) {

        if (names == null || names.size() == 0) {
            return null;
        }

        this.input = names;
        size = names.size();
        quickSort(0, size - 1);
        return names;
    }

    /**
     * Metodo de QuickSort.
     * @param low int es el primer dato en la posición[0] del arraylist que le ingresemos.
     * @param high int es el ultimo dato en el arraylist que le ingresemos.
     */
    private void quickSort(int low, int high) {
        int i = low;
        int j = high;

        // pivot is middle index

        Documento pivot = input.get(low + (high - low) / 2);
        // Divide into two arrays
        while (i <= j) {
            // full string ...
            while (input.get(i).getNombre().toLowerCase().compareTo((pivot.getNombre().toLowerCase())) < 0) {
                i++;
            }
            while (input.get(j).getNombre().toLowerCase().compareTo((pivot.getNombre().toLowerCase())) > 0) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }

        // calls quickSort() method recursively
        if (low < j) {
            quickSort(low, j);
        }

        if (i < high) {
            quickSort(i, high);
        }
    }

    /**
     * Metodo que realiza el swap de los valores.
     * @param i int el es valor que estamos comparando en la posición[i] del arraylist.
     * @param j int el es valor que estamos comparando en la posición[j] del arraylist.
     */
    private void swap(int i, int j) {
        Documento temp = input.get(i);
        input.set(i, input.get(j));
        input.set(j, temp);

    }
}
