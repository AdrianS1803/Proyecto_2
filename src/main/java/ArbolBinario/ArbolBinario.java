package ArbolBinario;

import java.io.Serializable;

/**
 *@author Sebastían Hernández Bonilla y Adrián Salas Solís
 *@version v0.1 octubre 2022
 */
public class ArbolBinario implements Serializable {

    private ArbolBinarioNodo root;
    private int comparaciones = 0;

    /**
     * Constructor de la clase ArbolBinario.
     */
    public ArbolBinario(){
        root = null;
    }

    /**
     * Recupera la raíz del árbol.
     * @return ArbolBinarioNodo Es la raíz del árbol.
     */
    public ArbolBinarioNodo getRoot(){
        return this.root;
    }

    /**
     * Recupera el número de comparaciones realizadas para obtener una busqueda.
     * @return Integer Es el número de comparaciones.
     */
    public int getComparaciones(){return this.comparaciones;}

    /**
     * Inserta un nuevo nodo en el árbol.
     * @param data String Es la información del nodo a insertar.
     */
    public void insertNode(String data){
        ArbolBinarioNodo newNode = new ArbolBinarioNodo(data);
        if(root == null){
            root = newNode;
        }else{
           ArbolBinarioNodo padre;
           ArbolBinarioNodo idetificador = root;
           while (true){
               padre = idetificador;
               if(data.compareTo(idetificador.getData())<0){
                   idetificador = idetificador.getLeftchild();

                   if(idetificador == null){
                       padre.setLeftchild(newNode);
                       return;
                   }
               }else{
                   idetificador = idetificador.getRightchild();
                   if(idetificador == null){
                       padre.setRightchild(newNode);
                       return;
                   }
               }
           }
        }
    }

    /**
     * Realiza una busqueda dentro del árbol y devuelve el nodo que coincida.
     * @param data String Es el dato que busca en los nodos del árbol.
     * @return ArbolBinarioNodo Es el nodo que coincide con la data.
     */
    public ArbolBinarioNodo search(String data){
        ArbolBinarioNodo identificador = root;

        int compara = 0;

        while( identificador.getData() != data ){
            if (data.compareTo(identificador.getData()) == 0){
                compara++;
                identificador.setComparaciones(compara);
                return identificador;
            }
            if (data.compareTo(identificador.getData())<0){ // El caso en que es  menor es cuando compareTo da negativo
                identificador = identificador.getLeftchild();
                compara++;

            }else{
                identificador = identificador.getRightchild();
                compara++;
            }
            if(identificador == null){
                return null;}
        }
        return identificador;
    }
}
