package ArbolBinario;

public class ArbolBinarioNodo<T extends Comparable<T>> {
    T element;
    ArbolBinarioNodo<T> left;
    ArbolBinarioNodo<T> right;

    public ArbolBinarioNodo(T element) {
        this(element, null, null);
    }

    public ArbolBinarioNodo(T element, ArbolBinarioNodo<T> left, ArbolBinarioNodo<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}
