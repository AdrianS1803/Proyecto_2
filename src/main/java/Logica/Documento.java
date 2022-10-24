package Logica;

import ArbolBinario.*;

import java.io.Serializable;

public class Documento implements Serializable {
    private String ruta;
    private String nombre;
    private String fecha;
    private Integer numero_palabras;
    private ArbolBinario arbolBinario;
    private AVL_new avl_new;
    //private AVL avl;
    public Documento(){}

    public String getRuta(){return this.ruta;}
    public ArbolBinario getArbolBinario(){
        return this.arbolBinario;
    }
    public AVL_new getAvl_new(){return this.avl_new;}
    public String getNombre(){
        return this.nombre;
    }
    public String getFecha(){
        return this.fecha;
    }
    public Integer getNumero_palabras(){
        return this.numero_palabras;
    }

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
}
