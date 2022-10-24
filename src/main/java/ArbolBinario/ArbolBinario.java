package ArbolBinario;

public class ArbolBinario{
    private ArbolBinarioNodo root;

    public ArbolBinario(){
        root = null;
    }
    public ArbolBinarioNodo getRoot(){
        return this.root;
    }
    public void insertNode(String data, Integer concurrencias){
        ArbolBinarioNodo newNode = new ArbolBinarioNodo(data, concurrencias);
        if(root == null){
            root = newNode;
        }else{
           ArbolBinarioNodo padre;
           ArbolBinarioNodo idetificador = root;
           while (true){
               padre = idetificador;
               if(data.equals(idetificador.getData())){///preguntar
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
        while(identificador.getData() != data){
            if(data.equals(identificador.getData())){////preguntar
                identificador.setLeftchild(identificador);
            }else{
                identificador.setRightchild(identificador);
            }
            if(identificador == null){
               return null;
            }
        }
        return identificador;
    }

    public void preOrden(ArbolBinarioNodo root){
        if(root != null){
            System.out.println(root.getData() + root.getConcurrencias() + ", ");
            preOrden(root.getLeftchild());
            preOrden(root.getRightchild());
        }
    }

    public void inOrden(ArbolBinarioNodo root){
        if(root != null){
            inOrden(root.getLeftchild());
            System.out.println(root.getData() + root.getConcurrencias() + ", ");
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
