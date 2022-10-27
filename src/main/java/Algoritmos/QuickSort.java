//https://www.lawebdelprogramador.com/foros/Java/1731852-Como-puedo-usar-Quicksort-para-ordenar-nombres-alfabeticamente.html
package Algoritmos;

import Logica.Documento;

import java.util.ArrayList;

public class QuickSort {
<<<<<<< HEAD
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
=======
    private Documento input[]; ///Array list
    private int length;

    public void sort(ArrayList<Documento> names) {

        if (names == null || names.size() == 0) {
            return;
        }

        this.input = names.toArray(new Documento[0]);
        length = names.size();
        quickSort(0, length - 1);
>>>>>>> main
    }
    /*
     * This method implements in-place quicksort algorithm recursively.
     */
    private void quickSort(int low, int high) {
        int i = low;
        int j = high;

        // pivot is middle index
<<<<<<< HEAD
        Documento pivot = input.get(low + (high - low) / 2);
        // Divide into two arrays
        while (i <= j) {
            // full string ...
            while (input.get(i).getNombre().compareTo((pivot.getNombre())) < 0) {
                i++;
            }
            while (input.get(j).getNombre().compareTo((pivot.getNombre())) > 0) {
=======
        String pivot = input[low + (high - low) / 2].getNombre();

        // Divide into two arrays
        while (i <= j) {
            // full string ...
            while (input[i].getNombre().compareToIgnoreCase(pivot) < 0) {
                i++;
            }
            while (input[j].getNombre().compareToIgnoreCase(pivot) > 0) {
>>>>>>> main
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

    private void swap(int i, int j) {
<<<<<<< HEAD
        Documento temp = input.get(i);
        input.set(i, input.get(j));
        input.set(j, temp);
=======
        Documento temp = input[i];
        input[i] = input[j];
        input[j] = temp;
>>>>>>> main
    }
}
