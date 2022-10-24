package Algoritmos;

public class RadixSort {
    public void radixSort(int[] array){
        int x, i, j;
        for (x = Integer.SIZE - 1; x >= 0; x--) {
            int auxiliar[] = new int[array.length];
            j=0;
            for (i = 0; i < array.length; i++) {
                boolean mover = array[i] << x >= 0;
                if(x == 0 ? !mover:mover){
                    auxiliar[j] = array[i];
                    j++;
                }else{
                    array[i-j] = array[i];
                }
            }
            for(i = j; i < auxiliar.length; i++){
                auxiliar[i] = array[i-j];
            }
            array = auxiliar;
        }
    }

    public void mostrarRadix(int[] array){
        Integer k;
        for(k = 0; k < array.length; k++){
            System.out.println("["+array[k]+"]");
        }
        System.out.println();
    }
}
