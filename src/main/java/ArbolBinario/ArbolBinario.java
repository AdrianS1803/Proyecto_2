package ArbolBinario;

public class ArbolBinario{
    private ArbolBinarioNodo root;

    public ArbolBinario(){
        root = null;
    }

    public void insertNode(Integer data, Integer ourrencias){
        ArbolBinarioNodo newNode = new ArbolBinarioNodo(data, ourrencias);
        if(root == null){
            root = newNode;
        }else{
           ArbolBinarioNodo padre;
           ArbolBinarioNodo idetificador = root;
           while (true){
               padre = idetificador;
               if(data < idetificador.getData()){
                   idetificador = idetificador.getLeftchild();
                   if(idetificador == null){
                       padre.setLeftchild() = newNode;
                       return;
                   }
               }else{
                   idetificador = idetificador.getRightchild();
                   if(idetificador == null){
                       padre.setRightchild() = newNode;
                       return;
                   }
               }
           }
        }
    }
}
