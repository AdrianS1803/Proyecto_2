//https://www.lawebdelprogramador.com/foros/Java/1731852-Como-puedo-usar-Quicksort-para-ordenar-nombres-alfabeticamente.html
package Algoritmos;

import Logica.Documento;

import java.util.ArrayList;

public class QuickSort {

    private ArrayList<Documento> input;
    private int size;

    public ArrayList<Documento> sort(ArrayList<Documento> names) {

        if (names == null || names.size() == 0) {
            return null;
        }

        this.input = names;
        size = names.size();
        quickSort(0, size - 1);
        return names;
    }
    /*
     * This method implements in-place quicksort algorithm recursively.
     */
    private void quickSort(int low, int high) {
        int i = low;
        int j = high;

        // pivot is middle index

        Documento pivot = input.get(low + (high - low) / 2);
        // Divide into two arrays
        while (i <= j) {
            // full string ...
            while (input.get(i).getNombre().compareTo((pivot.getNombre())) < 0) {
                i++;
            }
            while (input.get(j).getNombre().compareTo((pivot.getNombre())) > 0) {
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

    private void swap(int i, int j) {
        Documento temp = input.get(i);
        input.set(i, input.get(j));
        input.set(j, temp);

    }
}
