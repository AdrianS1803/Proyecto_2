package ArbolBinario;

import java.io.Serializable;

public class AVL_Nodo_new implements Serializable {
    String dato;
    int factor_equilibrio;
    AVL_Nodo_new hijoIzquierdo;
    AVL_Nodo_new hijoDerecho;

    public AVL_Nodo_new(String dato){
        this.dato = dato;
        this.factor_equilibrio = 0;
        this.hijoDerecho = null;
        this.hijoIzquierdo = null;

    }

}
