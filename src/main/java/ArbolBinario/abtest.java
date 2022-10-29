package ArbolBinario;

public class abtest {
    public static void main(String[] args){
        AVL_new arbol = new AVL_new();
        arbol.insertar("avion");
        System.out.println(" ");
        arbol.insertar("hola");
        System.out.println(" ");
        arbol.insertar("test");
        System.out.println(" ");
        arbol.insertar("pru");

        //arbol.preOrden(arbol.getRoot());
        //arbol.inOrden(arbol.getRoot());
        System.out.println(arbol.buscar("pru",  arbol.obtenerRaiz()).comparaciones);
       //arbol.postOrden(arbol.getRoot());

        String a = "prue";
        String b = "test";
    }
}
