package ArbolBinario;

public class ArbolBinarioNodo {
   private String dato;

    private Integer ocurrencias;
    private ArbolBinarioNodo leftchild;
    private ArbolBinarioNodo rightchild;

    public ArbolBinarioNodo(String data, Integer ocurrencias) {
        this.dato = data;
        this.ocurrencias = ocurrencias;
        this.leftchild = null;
        this.rightchild = null;
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
