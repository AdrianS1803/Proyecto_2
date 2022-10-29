package Logica;

import ArbolBinario.*;

import java.io.Serializable;

/**
 *@author Sebastían Hernández Bonilla y Adrián Salas Solís
 *@version v0.1 octubre 2022
 */

public class Documento implements Serializable {
    private String ruta;
    private String nombre;
    private String fecha;
    private Integer numero_palabras;
    private ArbolBinario arbolBinario;
    private AVL_new avl_new;
    private int comparaciones_AVL;
    private int comparaciones_ArbolBinario;

    /**
     * Constructor de la clase objeto Documento.
     */
    public Documento(){}

    /**
     * Obtiene la ruta del Objeto Documento.
     * @return String es la ruta del documento.
     */
    public String getRuta(){return this.ruta;}

    /**
     * Obtiene el árbolbinario del Objeto Documento.
     * @return árbolBinario es el árbol binario del documento.
     */
    public ArbolBinario getArbolBinario(){
        return this.arbolBinario;
    }

    /**
     * Obtiene la ruta del Objeto Documento.
     * @return Avl_new es el AVl del documento.
     */
    public AVL_new getAvl_new(){return this.avl_new;}

    /**
     * Obtiene el nombre del documento.
     * @return String es el nombre del documento.
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Obtiene la fecha de creación del documento.
     * @return String es la fecha de creación del documento.
     */
    public String getFecha(){
        return this.fecha;
    }

    /**
     * Obtiene el número de palabras que tiene el documento.
     * @return Integer es el número de palabras del documento.
     */
    public Integer getNumero_palabras(){
        return this.numero_palabras;
    }

    /**
     * Obtiene el número de comparaciones del AVL.
     * @return Integer el número de comparaciones del AVL.
     */
    public int getComparaciones_AVL(){return this.comparaciones_AVL;}

    /**
     * Obtiene el numero de comparaciones del árbol binario.
     * @return Integer el número de comparaciones del árbol binario.
     */
    public int getComparaciones_ArbolBinario(){return this.comparaciones_ArbolBinario;}

    /**
     * Setea la ruta donde está el archivo.
     * @param ruta String es la ruta del archivo.
     */
    public void setRuta(String ruta){this.ruta = ruta;}

    /**
     * Setea el nombre del archivo.
     * @param nombre String es el nombre del archivo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Setea la fecha del archivo.
     * @param fecha String es la fecha del archivo.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Setea el número de palabras del archivo.
     * @param numero_palabras Integer es el número de palabras del archivo.
     */
    public void setNumero_palabras(Integer numero_palabras) {
        this.numero_palabras = numero_palabras;
    }

    /**
     * Setea un árbol binario.
     * @param arbolBinario ArbolBinario es el árbol binario.
     */
    public void setArbolBinario(ArbolBinario arbolBinario){this.arbolBinario = arbolBinario;}

    /**
     * Setea el AVL.
     * @param avl_new AVL es el AVL.
     */
    public void setAvl_new(AVL_new avl_new){this.avl_new = avl_new;}

    /**
     * Setea las comparaciones del AVL.
     * @param comparaciones_AVL Integer es el número de comparaciones del AVL.
     */
    public void setComparaciones_AVL(int comparaciones_AVL){this.comparaciones_AVL = comparaciones_AVL;}

    /**
     * Setea las comparaciones del árbol binario.
     * @param comparaciones_ArbolBinario Integer es el número de comparaciones del árbol binario.
     */
    public void setComparaciones_ArbolBinario(int comparaciones_ArbolBinario){this.comparaciones_ArbolBinario = comparaciones_ArbolBinario;}

}
