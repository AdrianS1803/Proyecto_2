package ArbolBinario;

import java.io.Serializable;

public class ArbolBinarioNodo implements Serializable {
   private String dato;

    private Integer concurrencias;
    private ArbolBinarioNodo leftchild;
    private ArbolBinarioNodo rightchild;

    public ArbolBinarioNodo(String data) {
        this.dato = data;

        this.leftchild = null;
        this.rightchild = null;
    }

    public Integer getConcurrencias() {
        return concurrencias;
    }

    public String getData(){
        return this.dato;
    }

    public ArbolBinarioNodo getLeftchild(){
        return this.leftchild;
    }

    public void setLeftchild(ArbolBinarioNodo leftchild) {
        this.leftchild = leftchild;
    }

    public ArbolBinarioNodo getRightchild(){
        return this.rightchild;
    }

    public void setRightchild(ArbolBinarioNodo rightchild) {
        this.rightchild = rightchild;
    }
}
