package Algoritmos;

import java.util.Arrays;

public class testquick {
    public static void main(String[] args){
      String arrayPrueba[] = {"hola", "adios", "comida", "avion", "pingota"};
      QuickSort algoritmo = new QuickSort();
      algoritmo.sort(arrayPrueba);
      System.out.println(Arrays.toString(arrayPrueba));
    }
}
