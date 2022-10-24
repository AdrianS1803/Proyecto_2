package Algoritmos;

public class testquick {
    public static void main(String[] args){
        QuickSort ordenar = new QuickSort();
        Integer arrayPrueba[] = {40,6,7,8,100,5,3,80};
        ordenar.quickSort(arrayPrueba, 0, arrayPrueba.length-1);
        ordenar.mostrarQuick(arrayPrueba);
    }
}
