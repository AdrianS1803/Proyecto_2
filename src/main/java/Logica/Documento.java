package Logica;

import ArbolBinario.ArbolBinario;

import java.io.Serializable;

public class Documento implements Serializable {
    private String ruta;
    private String nombre;
    private String fecha;
    private Integer numero_palabras;
    private ArbolBinario arbolBinario;
    //private AVL avl;
    public Documento(){}

    public String getRuta(){return this.ruta;}
    public ArbolBinario getArbolBinario(){
        return this.arbolBinario;
    }
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
}
