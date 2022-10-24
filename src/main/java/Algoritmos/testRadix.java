package Algoritmos;

public class testRadix {
    public static void main(String[] args){
        RadixSort ordenar = new RadixSort();
        int arrayPrueba[] = {55,4,43,44,2,10};
        ordenar.mostrarRadix(arrayPrueba);
        ordenar.radixSort(arrayPrueba);
        ordenar.mostrarRadix(arrayPrueba);
    }
}
