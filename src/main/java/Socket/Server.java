package Socket;

import Logica.Documento;
import Logica.Mensaje;
import Logica.Parse;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
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
    public void iniciar() throws IOException, ClassNotFoundException {
        server = new ServerSocket(puerto);
        System.out.println("Servidor iniciado");

        while (true){
            socket = server.accept();
            System.out.println("Cliente conectado");

            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            Mensaje mensaje = (Mensaje)objectInputStream.readObject();

            if (mensaje.getMensaje2() == null){
                ////---------------------------Estoy aqui, objetivo que compare los arboles y retorne el array con solo las palabras que se ocupa
                System.out.println("No indi");
                lista_contiene_palabra.clear();
                for(int i = 0; i<=linkedList_documento.size()-1; i++){
                    lista_contiene_palabra.add(linkedList_documento.get(i));
                }

                ArrayList<Documento> lista_mensaje = lista_contiene_palabra;
                objectOutputStream.writeObject(lista_mensaje);

                /*mensaje.setMensaje("Server: " + mensaje.getMensaje());

                System.out.println(mensaje.getMensaje());
                Mensaje server_mensaje = new Mensaje(mensaje.getMensaje(), mensaje.getMensaje2());

                objectOutputStream.writeObject(server_mensaje);*/
                System.out.println("Cliete Desconectado");

            }else {
                if (mensaje.getMensaje2().equals("Indizando")){
                    System.out.println("Ind");
                    indizar();
                    System.out.println("Indizacion completada");
                    objectOutputStream.writeObject(lista_contiene_palabra);

                    System.out.println("Cliete Desconectado");
                }
            }
        }
    }


    private Documento ir_parse(File file, String searching) throws IOException, InvalidFormatException {
        Parse parse = new Parse();
        return parse.parseDocument(file, searching);
    }
    private void indizar(){
        File ruta = new File("Archivos");

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
                    //----------------
                    lista_temp.add(documento);
                }
            }else {
                Documento documento = new Documento();
                documento.setRuta(file.getAbsolutePath());
                lista_temp.add(documento);
            }
        }
        for (int i = 0; i <= lista_temp.size()-1; i++){
            System.out.println(lista_temp.get(i).getRuta());
        }

        this.linkedList_documento = lista_temp;
    }
    private void search_word(String searching_word){
        for (int i = 0; i<=linkedList_documento.size()-1; i++){
            this.lista_contiene_palabra.add(linkedList_documento.get(i));
        }


        /*for (int i = 0; i<=linkedList_documento.size()-1; i++){
            if (searching_word.in(linkedList_documento.get(i).getArbol)){ //No se como se pone esta linea
                //que la busque en el arbol
                this.lista_contiene_palabra.add(linkedList_documento.get(i))

            }
        }*/

    }

}