package Algoritmos;

public class BubbleSort {
    private Long i;
    private Long j;
    private Long ordenador;

    public BubbleSort(){
        this.i = Long.valueOf(0);
        this.j = Long.valueOf(0);
        this.ordenador = Long.valueOf(0);
    }

    public void BubbleSort(Long[] array){
        for(i = Long.valueOf(0); i < array.length; i++){
            for(j = i+1; j < array.length; j++){
                if(array[Math.toIntExact(i)] > array[Math.toIntExact(j)]){
                    ordenador = array[Math.toIntExact(i)];
                    array[Math.toIntExact(i)] = array[Math.toIntExact(j)];
                    array[Math.toIntExact(j)] = ordenador;
                }
            }
        }
    }

    public void mostrar(Long[] array){
        Integer k;
        for(k = 0; k < array.length; k++){
            System.out.println("["+array[k]+"]");
        }
        System.out.println();
    }

}
