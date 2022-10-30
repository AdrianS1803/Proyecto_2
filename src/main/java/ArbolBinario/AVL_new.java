package ArbolBinario;

import java.io.Serializable;

/**
 *@author Sebastían Hernández Bonilla y Adrián Salas Solís
 *@version v0.1 octubre 2022
 */
public class AVL_new implements Serializable {
    private int comparaciones = 0;
    private AVL_Nodo_new raiz;

    /**
     * Costructor AVL_new.
     */
    public AVL_new(){
        raiz = null;
    }

    /**
     * Recupera la raíz de Avl.
     * @return AVL_Nodo_new es la raíz del Avl
     */
    public AVL_Nodo_new obtenerRaiz(){
        return raiz;
    }
//-*---------------------------------------------------------------------------
    /**
     * Recupera el número de comparaciones realizadas para hallar un nodo.
     * @return Integer es el número de comparaciones realizadas por el Avl.
     */
    public int getComparaciones(){return this.comparaciones;}
//--------------------------------------------------------------------------------------
    /**
     * Busca un nodo en el Avl a partir de un dato suministrado.
     * @param dato String dato que busca.
     * @param raiz AVL_Nodo_new es la raíz del árbol.
     * @return AVL_Nodo_new es el nodo que coincide con el dato buscado.
     */
    public AVL_Nodo_new buscar(String dato, AVL_Nodo_new raiz){
        System.out.println("aa");
        if (raiz == null){///ALgo pasa aqui
            comparaciones=0;
            return null;
        } else if (raiz.dato.toLowerCase() == dato.toLowerCase()) {
            comparaciones++;
            raiz.comparaciones = comparaciones;
            this.comparaciones = 0;
            System.out.println(raiz);
            return raiz;
        } else if (raiz.dato.toLowerCase().compareTo(dato.toLowerCase())<0) {//raiz.dato < dato
            comparaciones++;
            return buscar(dato.toLowerCase(), raiz.hijoDerecho);
        }else {
            comparaciones++;
            return buscar(dato.toLowerCase(), raiz.hijoIzquierdo);
        }
    }

    /**
     * Recupera el factor de equilibrio de un nodo.
     * @param avl_nodo_new avl_nodo_new es el nodo del que se obtiene el factor de equilibrio.
     * @return Integer es el factor de equilibrio del nodo.
     */
    public int obtenerFactorEquilibrio(AVL_Nodo_new avl_nodo_new){
        if (avl_nodo_new == null){
            return -1;
        }else {
            return avl_nodo_new.factor_equilibrio;
        }
    }

    /**
     * Aplica una rotación hacia la izquierda para balancear el Avl.
     * @param avl_nodo_new AVL_Nodo_new Es el nodo del que se basa la rotación.
     * @return AVL_Nodo_new Es el nodo ya rotado a la izquierda.
     */
    public AVL_Nodo_new rotacionIzquierda(AVL_Nodo_new avl_nodo_new){
        AVL_Nodo_new auxiliar = avl_nodo_new.hijoIzquierdo;
        avl_nodo_new.hijoIzquierdo = auxiliar.hijoDerecho;
        auxiliar.hijoDerecho = avl_nodo_new;
        avl_nodo_new.factor_equilibrio = Math.max(obtenerFactorEquilibrio(avl_nodo_new.hijoIzquierdo), obtenerFactorEquilibrio(avl_nodo_new.hijoDerecho))+1;
        auxiliar.factor_equilibrio = Math.max(obtenerFactorEquilibrio(auxiliar.hijoIzquierdo), obtenerFactorEquilibrio(auxiliar.hijoDerecho))+1;
        return auxiliar;
    }

    /**
     * Aplica una rotación hacia la derecha para balancear el Avl.
     * @param avl_nodo_new AVL_Nodo_new Es el nodo del que se basa la rotación.
     * @return AVL_Nodo_new Es el nodo ya rotado a la derecha.
     */
    public AVL_Nodo_new rotacionDerecha(AVL_Nodo_new avl_nodo_new){
        AVL_Nodo_new auxiliar = avl_nodo_new.hijoDerecho;
        avl_nodo_new.hijoDerecho = auxiliar.hijoIzquierdo;
        auxiliar.hijoIzquierdo = avl_nodo_new;
        avl_nodo_new.factor_equilibrio = Math.max(obtenerFactorEquilibrio(avl_nodo_new.hijoIzquierdo), obtenerFactorEquilibrio(avl_nodo_new.hijoDerecho))+1;
        auxiliar.factor_equilibrio = Math.max(obtenerFactorEquilibrio(auxiliar.hijoIzquierdo), obtenerFactorEquilibrio(auxiliar.hijoDerecho))+1;
        return auxiliar;
    }

    /**
     * Aplica una rotación doble hacia la izquierda para balancear el Avl.
     * @param avl_nodo_new AVL_Nodo_new Es el nodo del que se basa la rotación.
     * @return AVL_Nodo_new Es el nodo ya doblemente rotado a la izquierda.
     */
    public AVL_Nodo_new rotacionDobleIzquierda(AVL_Nodo_new avl_nodo_new){
        AVL_Nodo_new temporal;
        avl_nodo_new.hijoIzquierdo = rotacionDerecha(avl_nodo_new.hijoIzquierdo);
        temporal = rotacionIzquierda(avl_nodo_new);
        return temporal;
    }

    /**
     * Aplica una rotación doble hacia la derecha para balancear el Avl.
     * @param avl_nodo_new AVL_Nodo_new Es el nodo del que se basa la rotación.
     * @return AVL_Nodo_new Es el nodo ya doblemente rotado a la derecha.
     */
    public AVL_Nodo_new rotacionDobleDerecha(AVL_Nodo_new avl_nodo_new){
        AVL_Nodo_new temporal;
        avl_nodo_new.hijoDerecho = rotacionIzquierda(avl_nodo_new.hijoDerecho);
        temporal = rotacionDerecha(avl_nodo_new);
        return temporal;
    }

    /**
     * Inserta un nuevo nodo al Avl manteniendo el factor de equilibrio, llamado por insertar.
     * @param nuevo AVL_Nodo_new Es el nodo a insertar.
     * @param subArbol AVL_Nodo_new Funciona para la recursividad. Cumple la función del un subárbol.
     * @return AVL_Nodo_new Retorna el nodo que funciona como sub arbol.
     */
    public AVL_Nodo_new insertarAVL(AVL_Nodo_new nuevo, AVL_Nodo_new subArbol){
        AVL_Nodo_new nuevoPadre = subArbol;
        //System.out.println(nuevo.dato+" < "+subArbol.dato); //nuevo.dato.compareTo(subArbol.dato)<0
        if (nuevo.dato.compareTo(subArbol.dato)<0){///nuevo.dato < subArbol.dato
            if (subArbol.hijoIzquierdo == null){
                subArbol.hijoIzquierdo = nuevo;
            }else {
                subArbol.hijoIzquierdo = insertarAVL(nuevo, subArbol.hijoIzquierdo);
                if ((obtenerFactorEquilibrio(subArbol.hijoIzquierdo) - obtenerFactorEquilibrio(subArbol.hijoDerecho) == 2)){
                    if (nuevo.dato.compareTo(subArbol.hijoIzquierdo.dato)<0){///nuevo.dato < subArbol.hijoIzquierdo.dato
                        nuevoPadre = rotacionIzquierda(subArbol);
                    }else {
                        nuevoPadre = rotacionDobleIzquierda(subArbol);
                    }
                }
            }
        } else if (nuevo.dato.compareTo(subArbol.dato)>0) {/////nuevo.dato > subArbol.dato
            if (subArbol.hijoDerecho == null){
                subArbol.hijoDerecho = nuevo;
            }else {
                subArbol.hijoDerecho = insertarAVL(nuevo , subArbol.hijoDerecho);
                if ((obtenerFactorEquilibrio(subArbol.hijoDerecho) - obtenerFactorEquilibrio(subArbol.hijoIzquierdo) == 2)){
                    if (nuevo.dato.compareTo(subArbol.hijoDerecho.dato)>0){/////nuevo.dato > subArbol.hijoDerecho.dato
                        nuevoPadre = rotacionDerecha(subArbol);
                    }else {
                        nuevoPadre = rotacionDobleDerecha(subArbol);
                    }
                }
            }
            
        } else {
            System.out.println("Nodo Duplicado");
        }
        //Actualizar Factor de equiilibrio
        if ((subArbol.hijoIzquierdo == null) && (subArbol.hijoDerecho != null)){
            subArbol.factor_equilibrio = subArbol.hijoDerecho.factor_equilibrio + 1;
        } else if ((subArbol.hijoDerecho == null) && (subArbol.hijoIzquierdo != null)) {
            subArbol.factor_equilibrio = subArbol.hijoIzquierdo.factor_equilibrio + 1;
        }else {
            subArbol.factor_equilibrio = Math.max(obtenerFactorEquilibrio(subArbol.hijoIzquierdo), obtenerFactorEquilibrio(subArbol.hijoDerecho)) + 1;
        }
        return nuevoPadre;
    }

    /**
     * Inserta un nuevo nodo al arbol por medio de un dato.
     * @param dato String es el dato del nuevo nodo
     */
    public void insertar(String dato){
        AVL_Nodo_new nuevo = new AVL_Nodo_new(dato);
        if (raiz == null){
            raiz = nuevo;
        }else {
            raiz = insertarAVL(nuevo, raiz);
        }
    }
//--------------------------------------------------------------------Eliminar esto al final
    public void inOrder (AVL_Nodo_new avl_nodo_new){
        if (avl_nodo_new != null){
            inOrder(avl_nodo_new.hijoIzquierdo);
            System.out.print(avl_nodo_new.dato + ", ");
            inOrder(avl_nodo_new.hijoDerecho);
        }
    }

    public void preOrden(AVL_Nodo_new avl_nodo_new){
        if (avl_nodo_new != null){
            System.out.print(avl_nodo_new.dato + ", ");
            preOrden(avl_nodo_new.hijoIzquierdo);
            preOrden(avl_nodo_new.hijoDerecho);
        }
    }

    public void postOrden(AVL_Nodo_new avl_nodo_new){
        if (avl_nodo_new != null){
            postOrden(avl_nodo_new.hijoIzquierdo);
            postOrden(avl_nodo_new.hijoDerecho);
            System.out.print(avl_nodo_new.dato + ", ");

        }
    }
}
