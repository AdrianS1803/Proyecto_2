package ArbolBinario;

import java.io.Serializable;

/**
 *@author Sebastían Hernández Bonilla y Adrián Salas Solís
 *@version v0.1 octubre 2022
 */
public class ArbolBinarioNodo implements Serializable {
   private String dato;
    private int comparaciones = 0;
    private Integer concurrencias;
    private ArbolBinarioNodo leftchild;
    private ArbolBinarioNodo rightchild;

    /**
     * Constructor de la clase ArbolBinarioNodo, recibe un string.
     * @param data String dato que guarda el nodo.
     */
    public ArbolBinarioNodo(String data) {
        this.dato = data;

        this.leftchild = null;
        this.rightchild = null;
    }

    public Integer getConcurrencias() {
        return concurrencias;
    }

    /**
     * Retorna el dato del nodo.
     * @return String el dato del nodo.
     */
    public String getData(){
        return this.dato;
    }

    /**
     * Obtiene el hijo izquierdo del nodo.
     * @return ArbolBinarioNod el hijo izquierdo del nodo.
     */
    public ArbolBinarioNodo getLeftchild(){
        return this.leftchild;
    }

    /**
     * Setea el hijo izquierdo del nodo.
     * @param leftchild ArbolBinarioNodo es el nodo que se coloca como hijo izquierdo.
     */
    public void setLeftchild(ArbolBinarioNodo leftchild) {
        this.leftchild = leftchild;
    }

    /**
     * Obtiene el hijo derecho del nodo.
     * @return ArbolBinarioNodo es el hijo derecho del nodo.
     */
    public ArbolBinarioNodo getRightchild(){
        return this.rightchild;
    }

    /**
     * Setea el hijo derecho del nodo.
     * @param rightchild ArbolBinarioNodo es el nodo que se coloca como hijo derecho.
     */
    public void setRightchild(ArbolBinarioNodo rightchild) {
        this.rightchild = rightchild;
    }

    public int getComparaciones() {
        return comparaciones;
    }

    public void setComparaciones(int comparaciones) {
        this.comparaciones = comparaciones;
    }
}
