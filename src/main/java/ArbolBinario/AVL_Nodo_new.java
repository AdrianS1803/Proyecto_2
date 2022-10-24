package ArbolBinario;

public class AVL_Nodo_new {
    int dato;
    int factor_equilibrio;
    AVL_Nodo_new hijoIzquierdo;
    AVL_Nodo_new hijoDerecho;

    public AVL_Nodo_new(int dato){
        this.dato = dato;
        this.factor_equilibrio = 0;
        this.hijoDerecho = null;
        this.hijoIzquierdo = null;

    }

}
