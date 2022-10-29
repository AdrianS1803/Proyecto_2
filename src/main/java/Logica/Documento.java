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
     * Obtiene el abolbinario del Objeto Documento.
     * @return ArbolBinario es el arbol binario del documento.
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
     * Obtiene la fecha de creacion del documento.
     * @return String es la fecha de creacion del documento.
     */
    public String getFecha(){
        return this.fecha;
    }

    /**
     * Obtiene el numero de palbras que tiene el documento.
     * @return Integer es el numero de palabras del documento.
     */
    public Integer getNumero_palabras(){
        return this.numero_palabras;
    }

    /**
     * Obtiene el numero de comparaciones del AVL.
     * @return 
     */
    public int getComparaciones_AVL(){return this.comparaciones_AVL;}
    public int getComparaciones_ArbolBinario(){return this.comparaciones_ArbolBinario;}


    public void setRuta(String ruta){this.ruta = ruta;}
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void setNumero_palabras(Integer numero_palabras) {
        this.numero_palabras = numero_palabras;
    }
    public void setArbolBinario(ArbolBinario arbolBinario){this.arbolBinario = arbolBinario;}
    public void setAvl_new(AVL_new avl_new){this.avl_new = avl_new;}
    public void setComparaciones_AVL(int comparaciones_AVL){this.comparaciones_AVL = comparaciones_AVL;}
    public void setComparaciones_ArbolBinario(int comparaciones_ArbolBinario){this.comparaciones_ArbolBinario = comparaciones_ArbolBinario;}

}
