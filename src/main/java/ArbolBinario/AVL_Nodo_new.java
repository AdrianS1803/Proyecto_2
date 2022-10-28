package ArbolBinario;

import java.io.Serializable;

/**
 *@author Sebastían Hernández Bonilla y Adrián Salas Solís
 *@version v0.1 octubre 2022
 */
public class AVL_Nodo_new implements Serializable {
    String dato;
    int factor_equilibrio;
    AVL_Nodo_new hijoIzquierdo;
    AVL_Nodo_new hijoDerecho;

    /**
     * Constructor de la clase AVL_Nodo_new, recibe un dato que guarda la información.
     * @param dato String es el dato con la información.
     */
    public AVL_Nodo_new(String dato){
        this.dato = dato;
        this.factor_equilibrio = 0;
        this.hijoDerecho = null;
        this.hijoIzquierdo = null;

    }

}
