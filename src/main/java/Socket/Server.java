package Socket;

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

public class Server {
    private LinkedList<Documento> linkedList_documento;
    private ArrayList<Documento> lista_contiene_palabra = new ArrayList<>();
    private int puerto;
    private ServerSocket server = null;
    private Socket socket = null;

    public Server(Integer puerto){
        this.puerto = puerto;
    }
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

                
                /*System.out.println(linkedList_documento.get(0).getNombre());
                System.out.println(linkedList_documento.get(0).getArbolBinario().getRoot());

                ArrayList<Documento> lista_mensaje = new ArrayList<Documento>();
                Documento documento = new Documento();
                documento.setNombre("Test");
                lista_mensaje.add(documento);*/

                objectOutputStream.writeObject(lista_mensaje);
                System.out.println("Cliete Desconectado");

            }else {//Si es una indizacion

                if (mensaje.getMensaje2().equals("Indizando")){
                    System.out.println("Indizacion: ");
                    indizar();
                    System.out.println("Indizacion completada");
                    objectOutputStream.writeObject(lista_contiene_palabra);

                    System.out.println("Cliete Desconectado");
                }
            }
        }
    }

    private void indizar() throws IOException, InvalidFormatException {
        File ruta = new File("Archivos");

        Parse parse = new Parse();

        String[] archives_name = ruta.list();
        LinkedList<Documento> lista_temp = new LinkedList<>();

        for (int i=0; i<archives_name.length; i++){

            File file = new File(ruta.getAbsolutePath(), archives_name[i]); //Directorio en el que esta y el nombre del archivo en el que voy en loop

            if (file.isDirectory()){
                String[] archivos_subcarpeta = file.list();

                for (int j=0;j<archivos_subcarpeta.length;j++){
                    File sub_file = new File(file.getAbsolutePath(), archivos_subcarpeta[j]);

                    Documento documento = new Documento();

                    //-----------Setea los datos

                    documento.setRuta(sub_file.getAbsolutePath());
                    documento.setNombre(sub_file.getName());

                    BasicFileAttributes attr = Files.readAttributes(sub_file.toPath(), BasicFileAttributes.class);
                    documento.setFecha(String.valueOf(attr.creationTime()));


                    parse.parseDocument(documento);
                    //----------------
                    lista_temp.add(documento);
                }
            }else {
                Documento documento = new Documento();
                // Setea los datos------------
                documento.setRuta(file.getAbsolutePath());
                documento.setNombre(file.getName());

                BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                documento.setFecha(String.valueOf(attr.creationTime()));

                parse.parseDocument(documento);

                //------------------------
                lista_temp.add(documento);
            }
        }

        this.linkedList_documento = lista_temp;
    }

    private void search_word(String searching_word){
        lista_contiene_palabra.clear();

        for (int i = 0; i<=linkedList_documento.size()-1; i++){
            if (linkedList_documento.get(i).getArbolBinario().search(searching_word)!=null){
                System.out.println(linkedList_documento.get(i).getArbolBinario().getRoot().getData());

                lista_contiene_palabra.add(linkedList_documento.get(i));
            }
        }
    }

}