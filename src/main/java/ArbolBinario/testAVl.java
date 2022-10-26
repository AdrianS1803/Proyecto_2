package ArbolBinario;

public class testAVl {
    public static void main(String[] args){
       AVL_new arbol = new AVL_new();
        arbol.insertar(10);
        arbol.insertar(5);
        /*arbol.insertar(13);
        arbol.insertar(1);
        arbol.insertar(6);
        arbol.insertar(17);
        arbol.insertar(16);*/
        //arbol.preOrden(arbol.obtenerRaiz());


        String palabra1 = "ave";
        String palabra2 = "zorro";
        System.out.println(palabra1.compareTo(palabra2));

        //System.out.println(comparaPalabra(palabra1, palabra2));

       /* AVL_new avl_new = new AVL_new();

        avl_new.insertar(1);

        System.out.println(avl_new.buscar(1, avl_new.obtenerRaiz()).dato);*/


    }
    public static String comparaPalabra(String palabra1, String palabra2){
        int resultado = palabra1.compareTo(palabra2);

        String palabra_resultado = null;
        if (resultado>0){
            palabra_resultado = palabra2;
        } else if (resultado<0) {
            palabra_resultado = palabra1;
        }else if (resultado==0){
            palabra_resultado = "misma palabra";
        }
        return palabra_resultado;
    }
}
