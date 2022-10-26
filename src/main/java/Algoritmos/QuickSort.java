//https://www.lawebdelprogramador.com/foros/Java/1731852-Como-puedo-usar-Quicksort-para-ordenar-nombres-alfabeticamente.html
package Algoritmos;

import Logica.Documento;

import java.util.ArrayList;

public class QuickSort {
    private Documento input[]; ///Array list
    private int length;

    public void sort(ArrayList<Documento> names) {

        if (names == null || names.size() == 0) {
            return;
        }

        this.input = names.toArray(new Documento[0]);
        length = names.size();
        quickSort(0, length - 1);
    }

    /*
     * This method implements in-place quicksort algorithm recursively.
     */
    private void quickSort(int low, int high) {
        int i = low;
        int j = high;

        // pivot is middle index
        String pivot = input[low + (high - low) / 2].getNombre();

        // Divide into two arrays
        while (i <= j) {
            // full string ...
            while (input[i].getNombre().compareToIgnoreCase(pivot) < 0) {
                i++;
            }
            while (input[j].getNombre().compareToIgnoreCase(pivot) > 0) {
                j--;
            }

            if (i <= j) {
                swap(i, j);
                // move index to next position on both sides
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

    private int getInitial(String input) {
        String values [] = input.split(" ");
        return (int) values[0].charAt(0) + (int) values[1].charAt(0);
    }

    private void swap(int i, int j) {
        Documento temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
