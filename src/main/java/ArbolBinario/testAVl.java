package ArbolBinario;

public class testAVl {
    public static void main(String[] args){
        AVL arbol = new AVL();
        arbol.insert(10, 3);
        arbol.insert(15, 6);
        arbol.insert(3, 7);
        arbol.insert(17, 2);
        arbol.insert(5, 1);
        arbol.preOrden(arbol.getRoot());
    } 
}
