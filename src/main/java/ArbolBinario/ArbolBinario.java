package ArbolBinario;

import java.io.Serializable;

public class ArbolBinario implements Serializable {
    private ArbolBinarioNodo root;
    private int comparaciones = 0;

    public ArbolBinario(){
        root = null;
    }
    public ArbolBinarioNodo getRoot(){
        return this.root;
    }
    public int getComparaciones(){return this.comparaciones;}
    public void insertNode(String data){
        ArbolBinarioNodo newNode = new ArbolBinarioNodo(data);
        if(root == null){
            root = newNode;
        }else{
           ArbolBinarioNodo padre;
           ArbolBinarioNodo idetificador = root;
           while (true){
               padre = idetificador;
               if(data.compareTo(idetificador.getData())<0){///preguntar
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

    public ArbolBinarioNodo search(String data){
        ArbolBinarioNodo identificador = root;

        while( identificador.getData() != data ){
            if (data.compareTo(identificador.getData()) == 0){
                comparaciones++;
                return identificador;
                }
            if (data.compareTo(identificador.getData())<0){ // El caso en que es  menor es cuando compareTo da negativo
                identificador = identificador.getLeftchild();
                comparaciones++;

            }else{
                identificador = identificador.getRightchild();
                comparaciones++;
            }
            if(identificador == null){
                comparaciones++;
                return null;}
        }
        return identificador;
    }

    public void preOrden(ArbolBinarioNodo root){//Arreglar ocurrencias
        if(root != null){
            System.out.println(root.getData() + root.getConcurrencias() + ", ");
            preOrden(root.getLeftchild());
            preOrden(root.getRightchild());
        }
    }

    public void inOrden(ArbolBinarioNodo root){
        if(root != null){
            inOrden(root.getLeftchild());
            System.out.println(root.getData() + ", ");
            inOrden(root.getRightchild());
        }
    }

    public void postOrden(ArbolBinarioNodo root){
        if(root != null){
            postOrden(root.getLeftchild());
            postOrden(root.getRightchild());
            System.out.println(root.getData() + root.getConcurrencias() + ", ");
        }
    }


}
