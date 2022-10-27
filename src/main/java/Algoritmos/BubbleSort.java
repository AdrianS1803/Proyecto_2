package Algoritmos;

import Logica.Documento;

import java.util.ArrayList;

public class BubbleSort {
    private int i;
    private int j;
    private Documento ordenador;

    public ArrayList<Documento> BubbleSort(ArrayList<Documento> array){

        for(i = 0; i < array.size(); i++){
            for(j = i+1; j < array.size(); j++){
                if(Integer.parseInt(array.get(i).getFecha()) > Integer.parseInt(array.get(j).getFecha())){
                    ordenador = array.get(i);
                    array.set(i, array.get(j));
                    array.set(j, ordenador);
                }
            }
    }
        return array;
    }
}
