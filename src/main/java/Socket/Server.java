package Socket;

import Algoritmos.BubbleSort;
import Algoritmos.QuickSort;
import Algoritmos.RadixSort;
import ArbolBinario.AVL_new;
import ArbolBinario.ArbolBinario;
import ArbolBinario.ArbolBinarioNodo;
import ArbolBinario.AVL_new;
import ArbolBinario.AVL_Nodo_new;
import Logica.Documento;
import Logica.Mensaje;
import Logica.Parse;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *@author Sebastían Hernández Bonilla y Adrián Salas Solís
 *@version v0.1 octubre 2022
 */
public class Server {
    private LinkedList<Documento> linkedList_documento;
    private ArrayList<Documento> lista_contiene_palabra = new ArrayList<>();
    private int puerto;
    private ServerSocket server = null;
    private Socket socket = null;

    /**
     * Constructor del Server
     * @param puerto Integer Es el puerto al que se conecta el servidor.
     */
    public Server(Integer puerto){
        this.puerto = puerto;
    }

    /**
     * Iniciar el servidor, que espera un Mensaje del cliente y devuele una ArrayList de Documentos dependiendo de lo recibido en el mensaje.
     * @throws IOException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws ClassNotFoundException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws InvalidFormatException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
    public void iniciar() throws IOException, ClassNotFoundException, InvalidFormatException {
        server = new ServerSocket(puerto);
        System.out.println("Servidor iniciado");

        while (true){
            socket = server.accept();
            System.out.println("\nCliente conectado");

            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            Mensaje mensaje = (Mensaje)objectInputStream.readObject();


            if (mensaje.getMensaje2() == null){//Si es una busqueda
                ////---------------------------Estoy aqui, objetivo que compare los arboles y retorne el array con solo las palabras que se ocupa
                System.out.println("Busqueda de " + mensaje.getMensaje());

                search_word(mensaje.getMensaje());

                ArrayList<Documento> lista_mensaje = lista_contiene_palabra;

                objectOutputStream.writeObject(lista_mensaje);
                System.out.println("Cliete Desconectado");

            }else {//Si es uno es una busqueda de palabra

                if (mensaje.getMensaje2().equals("Indizando")){
                    System.out.println("Indizacion: ");
                    indizar();
                    System.out.println("Indizacion completada");

                    objectOutputStream.writeObject(lista_contiene_palabra);

                    System.out.println("Cliete Desconectado");

                } else if (mensaje.getMensaje2().equals("Palabras")) {
                    System.out.println("RadixSort: ");

                    //search_word(mensaje.getMensaje());
                    RadixSort radixSort = new RadixSort();
                    lista_contiene_palabra = radixSort.sort(lista_contiene_palabra);

                    System.out.println("RadixSort terminado");

                    ArrayList<Documento> lista_mensaje = lista_contiene_palabra;
                    objectOutputStream.writeObject(lista_mensaje);

                    System.out.println("Cliente Desconectado");

                } else if (mensaje.getMensaje2().equals("Fecha")) {
                    System.out.println("BubbleSort: ");

                    //search_word(mensaje.getMensaje());
                    BubbleSort bubbleSort = new BubbleSort();
                    lista_contiene_palabra = bubbleSort.sort(lista_contiene_palabra);

                    System.out.println("BubbleSort Terminado");

                    ArrayList<Documento> lista_mensaje = lista_contiene_palabra;
                    objectOutputStream.writeObject(lista_mensaje);

                    System.out.println("Client Desconectado");

                } else if (mensaje.getMensaje2().equals("Nombre")) {
                    System.out.println("QuickSort: ");

                    QuickSort quickSort = new QuickSort();

                    lista_contiene_palabra = quickSort.sort(lista_contiene_palabra);

                    System.out.println("QuickSort Terminado");

                    ArrayList<Documento> lista_mensaje = lista_contiene_palabra;
                    objectOutputStream.writeObject(lista_mensaje);

                    System.out.println("Cliente Desconectado");

                }else {
                    System.out.println("Error");
                }

            }
        }
    }

    /**
     * Indiza los documentos de la carpeta especificada.
     * @throws IOException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws InvalidFormatException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
    private void indizar() throws IOException, InvalidFormatException {
        File ruta = new File("Archivos");

        Parse parse = new Parse();

        String[] archives_name = ruta.list();
        LinkedList<Documento> lista_temp = new LinkedList<>();

        ArrayList<Documento> lista_temp2 = new ArrayList<>();

        for (int i=0; i<archives_name.length; i++){

            File file = new File(ruta.getAbsolutePath(), archives_name[i]); //Directorio en el que esta y el nombre del archivo en el que voy en loop

            if (file.isDirectory()){
                String[] archivos_subcarpeta = file.list();

                for (int j=0;j<archivos_subcarpeta.length;j++){//Para recorrer dentro de las carpetas de la carpeta archivo
                    File sub_file = new File(file.getAbsolutePath(), archivos_subcarpeta[j]);

                    Documento documento = new Documento();

                    //-----------Setea los datos

                    documento.setRuta(sub_file.getAbsolutePath());
                    documento.setNombre(sub_file.getName());

                    BasicFileAttributes attr = Files.readAttributes(sub_file.toPath(), BasicFileAttributes.class);
                    documento.setFecha(String.valueOf(attr.creationTime().toMillis()/1000));


                    parse.parseDocument(documento);
                    //----------------
                    lista_temp.add(documento);
                    lista_temp2.add(documento);
                }
            }else {
                Documento documento = new Documento();
                // Setea los datos------------
                documento.setRuta(file.getAbsolutePath());
                documento.setNombre(file.getName());

                BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                documento.setFecha(String.valueOf(attr.creationTime().toMillis()/1000));

                parse.parseDocument(documento);

                //------------------------
                lista_temp.add(documento);
                lista_temp2.add(documento);
            }
        }
        // Aquí ya los setea como atributos del server
        this.linkedList_documento = lista_temp;
        this.lista_contiene_palabra = lista_temp2;
    }

    /**
     * Busca en los árboles una palabra en específico si la encuentra añade al la lista contiene palabra el documento.
     * @param searching_word String Palabra a buscar
     */
    private void search_word(String searching_word){
        lista_contiene_palabra.clear();

        for (int i = 0; i<=linkedList_documento.size()-1; i++){
            if (linkedList_documento.get(i).getArbolBinario().search(searching_word)!=null){
                //System.out.println(linkedList_documento.get(i).getArbolBinario().search(searching_word));

                (linkedList_documento.get(i).getArbolBinario().search(searching_word)).getComparaciones();

                linkedList_documento.get(i).setComparaciones_ArbolBinario((linkedList_documento.get(i).getArbolBinario().search(searching_word)).getComparaciones());

                lista_contiene_palabra.add(linkedList_documento.get(i));
            }
        }
        for (int j = 0; j<=linkedList_documento.size()-1;j++){
            System.out.println(linkedList_documento.get(j).getAvl_new().buscar(searching_word, linkedList_documento.get(j).getAvl_new().obtenerRaiz()));
            if (linkedList_documento.get(j).getAvl_new().buscar(searching_word,linkedList_documento.get(j).getAvl_new().obtenerRaiz())!=null){
                AVL_new avl_new = linkedList_documento.get(j).getAvl_new();
                AVL_Nodo_new avlNodo = avl_new.buscar(searching_word, avl_new.obtenerRaiz());

                System.out.println(avlNodo.comparaciones);
                linkedList_documento.get(j).setComparaciones_AVL(avlNodo.comparaciones);

                if (!linkedList_documento.contains(linkedList_documento.get(j))){
                    lista_contiene_palabra.add(linkedList_documento.get(j));
                }
            }
        }
    }

}