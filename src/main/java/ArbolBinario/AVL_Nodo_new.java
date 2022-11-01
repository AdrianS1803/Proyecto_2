package ArbolBinario;

import java.io.Serializable;

/**
 *@author Sebastían Hernández Bonilla y Adrián Salas Solís
 *@version v0.1 octubre 2022
 */
public class AVL_Nodo_new implements Serializable {
    public String dato;
    private int comparaciones;
    int factor_equilibrio;
    public AVL_Nodo_new hijoIzquierdo;
    public AVL_Nodo_new hijoDerecho;


    private String[] frase = new  String[2];

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

    public String getFraseIndice(int i) {
        return frase[i];
    }

    public void setFrase(String[] frase) {
        this.frase = frase;
    }


    public int getComparaciones() {
        return comparaciones;
    }

    public void setComparaciones(int comparaciones) {
        this.comparaciones = comparaciones;
    }
}
