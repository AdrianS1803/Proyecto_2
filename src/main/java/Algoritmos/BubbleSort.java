package Algoritmos;

public class BubbleSort {
    private Integer i;
    private Integer j;
    private Integer ordenador;

    public BubbleSort(){
        this.i = 0;
        this.j = 0;
        this.ordenador = 0;
    }

    public void BubbleSort(Integer[] array){
        for(i = 0; i < array.length; i++){
            for(j = i+1; j < array.length; j++){
                if(array[i] > array[j]){
                    ordenador = array[i];
                    array[i] = array[j];
                    array[j] = ordenador;
                }
            }
        }
    }

    public void mostrar(Integer[] array){
        Integer k;
        for(k = 0; k < array.length; k++){
            System.out.println("["+array[k]+"]");
        }
        System.out.println();
    }

}
