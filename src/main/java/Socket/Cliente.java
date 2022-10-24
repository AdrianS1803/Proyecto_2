package Socket;


import Logica.Documento;
import Logica.Mensaje;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Cliente {

    private ArrayList<Documento> lista_contiene_palabra = new ArrayList<>();
    private Mensaje mensaje;
    private String Host;
    private int puerto;

    public Cliente(String Host, Integer puerto){
        this.Host = Host;
        this.puerto = puerto;
    }

    public ArrayList<Documento> sendSearch(Mensaje enviando){
        try {
            Socket socket = new Socket(Host, puerto);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            objectOutputStream.writeObject(enviando);
            //----------
            lista_contiene_palabra = (ArrayList<Documento>)objectInputStream.readObject();
            //---------

            socket.close();
        }catch (Exception e){
            System.out.println(e);
        }

        return lista_contiene_palabra;
    }

    public ArrayList<Documento> sendIndizacion(Mensaje enviando){
        try {
            Socket socket = new Socket(Host, puerto);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            objectOutputStream.writeObject(enviando);

            this.lista_contiene_palabra = (ArrayList<Documento>)objectInputStream.readObject();

            socket.close();
        }catch (Exception e){
            System.out.println(e);
        }


        return lista_contiene_palabra;
    }

    public void sendMensaje(Mensaje mensaje){
        try {
            Socket socket = new Socket(Host, puerto);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            objectOutputStream.writeObject(mensaje);

            Mensaje returnMensaje = (Mensaje) objectInputStream.readObject();

            System.out.println(returnMensaje.getMensaje()+"ubica");
            socket.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}