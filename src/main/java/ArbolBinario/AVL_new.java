package ArbolBinario;

import java.io.Serializable;

public class AVL_new implements Serializable {
    private AVL_Nodo_new raiz;

    public AVL_new(){
        raiz = null;
    }
    public AVL_Nodo_new obtenerRaiz(){
        return raiz;
    }

    public AVL_Nodo_new buscar(int dato, AVL_Nodo_new raiz){
        if (raiz == null){
            return null;
        } else if (raiz.dato == dato) {
            return raiz;
        } else if (raiz.dato < dato) {
            return buscar(dato, raiz.hijoDerecho);
        }else {
            return buscar(dato, raiz.hijoIzquierdo);
        }
    }

    public int obtenerFactorEquilibrio(AVL_Nodo_new avl_nodo_new){
        if (avl_nodo_new == null){
            return -1;
        }else {
            return avl_nodo_new.factor_equilibrio;
        }
    }

    public AVL_Nodo_new rotacionIzquierda(AVL_Nodo_new avl_nodo_new){
        AVL_Nodo_new auxiliar = avl_nodo_new.hijoIzquierdo;
        avl_nodo_new.hijoIzquierdo = auxiliar.hijoDerecho;
        auxiliar.hijoDerecho = avl_nodo_new;
        avl_nodo_new.factor_equilibrio = Math.max(obtenerFactorEquilibrio(avl_nodo_new.hijoIzquierdo), obtenerFactorEquilibrio(avl_nodo_new.hijoDerecho))+1;
        auxiliar.factor_equilibrio = Math.max(obtenerFactorEquilibrio(auxiliar.hijoIzquierdo), obtenerFactorEquilibrio(auxiliar.hijoDerecho))+1;
        return auxiliar;
    }

    public AVL_Nodo_new rotacionDerecha(AVL_Nodo_new avl_nodo_new){
        AVL_Nodo_new auxiliar = avl_nodo_new.hijoDerecho;
        avl_nodo_new.hijoDerecho = auxiliar.hijoIzquierdo;
        auxiliar.hijoIzquierdo = avl_nodo_new;
        avl_nodo_new.factor_equilibrio = Math.max(obtenerFactorEquilibrio(avl_nodo_new.hijoIzquierdo), obtenerFactorEquilibrio(avl_nodo_new.hijoDerecho))+1;
        auxiliar.factor_equilibrio = Math.max(obtenerFactorEquilibrio(auxiliar.hijoIzquierdo), obtenerFactorEquilibrio(auxiliar.hijoDerecho))+1;
        return auxiliar;
    }

    public AVL_Nodo_new rotacionDobleIzquierda(AVL_Nodo_new avl_nodo_new){
        AVL_Nodo_new temporal;
        avl_nodo_new.hijoIzquierdo = rotacionDerecha(avl_nodo_new.hijoIzquierdo);
        temporal = rotacionIzquierda(avl_nodo_new);
        return temporal;
    }

    public AVL_Nodo_new rotacionDobleDerecha(AVL_Nodo_new avl_nodo_new){
        AVL_Nodo_new temporal;
        avl_nodo_new.hijoDerecho = rotacionIzquierda(avl_nodo_new.hijoDerecho);
        temporal = rotacionDerecha(avl_nodo_new);
        return temporal;
    }

    public AVL_Nodo_new insertarAVL(AVL_Nodo_new nuevo, AVL_Nodo_new subArbol){
        AVL_Nodo_new nuevoPadre = subArbol;
        System.out.println(nuevo.dato+" < "+subArbol.dato); //nuevo.dato.compareTo(subArbol.dato)<0
        if (nuevo.dato < subArbol.dato){///
            if (subArbol.hijoIzquierdo == null){
                subArbol.hijoIzquierdo = nuevo;
            }else {
                subArbol.hijoIzquierdo = insertarAVL(nuevo, subArbol.hijoIzquierdo);
                if ((obtenerFactorEquilibrio(subArbol.hijoIzquierdo) - obtenerFactorEquilibrio(subArbol.hijoDerecho) == 2)){
                    if (nuevo.dato < subArbol.hijoIzquierdo.dato){
                        nuevoPadre = rotacionIzquierda(subArbol);
                    }else {
                        nuevoPadre = rotacionDobleIzquierda(subArbol);
                    }
                }
            }
        } else if (nuevo.dato > subArbol.dato) {/////nuevo.dato.compareTo(subArbol.dato)>0
            if (subArbol.hijoDerecho == null){
                subArbol.hijoDerecho = nuevo;
            }else {
                subArbol.hijoDerecho = insertarAVL(nuevo , subArbol.hijoDerecho);
                if ((obtenerFactorEquilibrio(subArbol.hijoDerecho) - obtenerFactorEquilibrio(subArbol.hijoIzquierdo) == 2)){
                    if (nuevo.dato > subArbol.hijoDerecho.dato){/////nuevo.dato.compareTo(subArbol.dato)>0
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

    public void insertar(int dato){
        AVL_Nodo_new nuevo = new AVL_Nodo_new(dato);
        if (raiz == null){
            raiz = nuevo;
        }else {
            raiz = insertarAVL(nuevo, raiz);
        }
    }

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
