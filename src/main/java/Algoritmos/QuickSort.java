package Algoritmos;

public class QuickSort {
    private Integer i;
    private Integer j;
    private Integer pivot;

    public QuickSort(){
        this.i = 0;
        this.j = 0;
        this.pivot = 0;
    }

    public void quickSort(Integer[] array, Integer first, Integer last){
        Integer auxiliar = 0;
        i = first;
        j = last;
        pivot = array[(first+last)/2];
        do{
            while(array[i] < pivot){
                i++;
            }
            while(array[j] > pivot){
                j--;
            }
            if(i <= j){
                auxiliar = array[i];
                array[i] = array[j];
                array[j] = auxiliar;
                i++;
                j--;
            }
        }while(i <= j);
        if(first < j){
            quickSort(array, first, j);
        }
        if(i < last){
            quickSort(array, i, last);
        }
    }

    public void mostrarQuick(Integer[] array){
        Integer k;
        for(k = 0; k < array.length; k++){
            System.out.println("["+array[k]+"]");
        }
        System.out.println();
    }
}
