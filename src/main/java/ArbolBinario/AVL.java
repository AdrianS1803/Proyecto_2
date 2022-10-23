package ArbolBinario;

import GUI.Main;

public class AVL {
    private NodoAVL root;

    public AVL(){
        this.root = null;
    }

    public NodoAVL getRoot(){
        return this.root;
    }

    public NodoAVL searchNode(NodoAVL root, Integer dataAVL, Integer concurrenciasAVL){
        if(this.root == null){
            return null;
        }else if(root.getDataAVL() == dataAVL){
            return root;
        }else if(root.getDataAVL() < dataAVL){
            return searchNode(root.getAVLRightchild(), dataAVL, concurrenciasAVL);
        }else{
            return searchNode(root.getAVLLeftchild(), dataAVL, concurrenciasAVL);
        }
    }

    public int getFE(NodoAVL factorEquilibrio){
        if(factorEquilibrio == null){
            return -1;
        }else{
            return factorEquilibrio.getfactorEquilibrio();
        }
    }

    public NodoAVL rotacionSimpleLeft(NodoAVL node){
        NodoAVL identificador = node.getAVLLeftchild();
        node.setAVLLeftchild(identificador.getAVLRightchild());
        identificador.setAVLRightchild(node);
        node.setFactorEquilibrio(Math.max(getFE(node.getAVLLeftchild()), getFE(node.getAVLRightchild())) + 1) ;
        identificador.setFactorEquilibrio(Math.max(getFE(identificador.getAVLLeftchild()), getFE(identificador.getAVLRightchild())) + 1);
        return identificador;
    }

    public NodoAVL rotacionSimpleRight(NodoAVL node){
        NodoAVL identificador = node.getAVLRightchild();
        node.setAVLRightchild(identificador.getAVLLeftchild());
        identificador.setAVLLeftchild(node);
        node.setFactorEquilibrio(Math.max(getFE(node.getAVLLeftchild()), getFE(node.getAVLRightchild())) + 1) ;
        identificador.setFactorEquilibrio(Math.max(getFE(identificador.getAVLLeftchild()), getFE(identificador.getAVLRightchild())) + 1);
        return identificador;
    }

    public NodoAVL rotacionDobleLeft(NodoAVL node){
        NodoAVL identificador;
        node.setAVLLeftchild(rotacionSimpleLeft(node.getAVLLeftchild()));
        identificador = rotacionSimpleLeft(node);
        return identificador;
    }

    public NodoAVL rotacionDobleRight(NodoAVL node){
        NodoAVL identificador;
        node.setAVLRightchild(rotacionSimpleRight(node.getAVLRightchild()));
        identificador = rotacionSimpleRight(node);
        return identificador;
    }

    public NodoAVL insertNode(NodoAVL newNode, NodoAVL subNode){
        NodoAVL newPadre = subNode;
        if(newNode.getDataAVL() < subNode.getDataAVL()){
            if(subNode.getAVLLeftchild() == null){
                subNode.setAVLLeftchild(newNode);
            }else{
                subNode.setAVLLeftchild(insertNode(newNode, subNode.getAVLLeftchild()));
                if(getFE(subNode.getAVLLeftchild()) - getFE(subNode.getAVLRightchild()) == 2){
                    if(newNode.getDataAVL() < subNode.getAVLLeftchild().getDataAVL()){
                        newPadre = rotacionSimpleLeft(subNode);
                    }else{
                        newPadre = rotacionDobleLeft(subNode);
                    }
                }
            }
        }else if(newNode.getDataAVL() > subNode.getDataAVL()){
            if(subNode.getAVLRightchild() == null){
                subNode.setAVLRightchild(newNode);
            }else{
                subNode.setAVLRightchild(insertNode(newNode, subNode.getAVLRightchild()));
                if(getFE(subNode.getAVLRightchild()) - getFE(subNode.getAVLLeftchild()) == 2){
                    if(newNode.getDataAVL() > subNode.getAVLRightchild().getDataAVL()){
                        newPadre = rotacionSimpleRight(subNode);
                    }else{
                        newPadre = rotacionDobleRight(subNode);
                    }
                }
            }
        }else{
            System.out.println("duplicado");
        }
        if((subNode.getAVLLeftchild() == null) && (subNode.getAVLRightchild() != null)){
            subNode.setFactorEquilibrio(subNode.getAVLLeftchild().getfactorEquilibrio() + 1);
        }else if((subNode.getAVLRightchild() == null) && (subNode.getAVLLeftchild() != null)){
            subNode.setFactorEquilibrio(subNode.getAVLLeftchild().getfactorEquilibrio() + 1);
        }else{
            subNode.setFactorEquilibrio(Math.max(getFE(subNode.getAVLLeftchild()), getFE(subNode.getAVLRightchild())) + 1);
        }
        return newPadre;
    }

    public void insert(Integer dataAVL, Integer concurrencias){
        NodoAVL nuevoNodo = new NodoAVL(dataAVL, concurrencias);
        if(this.root == null){
            this.root = nuevoNodo;
        }else{
            this.root = insertNode(nuevoNodo, this.root);
        }
    }

    public void preOrden(NodoAVL root){
        if(root != null){
            System.out.println(root.getDataAVL() + root.getConcurrenciasAVL() + ", ");
            preOrden(root.getAVLLeftchild());
            preOrden(root.getAVLRightchild());
        }
    }

    public void inOrden(NodoAVL root){
        if(root != null){
            inOrden(root.getAVLLeftchild());
            System.out.println(root.getDataAVL() + root.getConcurrenciasAVL() + ", ");
            inOrden(root.getAVLRightchild());
        }
    }

    public void postOrden(NodoAVL root){
        if(root != null){
            postOrden(root.getAVLLeftchild());
            postOrden(root.getAVLRightchild());
            System.out.println(root.getDataAVL() + root.getConcurrenciasAVL() + ", ");
        }
    }

}
