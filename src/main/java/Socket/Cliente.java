package Socket;


import Logica.Documento;
import Logica.Mensaje;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Cliente {

    private ArrayList<Documento> lista_contiene_palabra = new ArrayList<>();
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

            lista_contiene_palabra = (ArrayList<Documento>)objectInputStream.readObject();

            socket.close();
        }catch (Exception e){
            System.out.println(e);
        }


        return lista_contiene_palabra;
    }
    //Retornara un array
    public ArrayList<Documento> sendAlgoritmo(Mensaje enviando){
        return sendMensaje(enviando);
    }

    private ArrayList<Documento> sendMensaje(Mensaje enviando) {
        try {
            Socket socket = new Socket(Host, puerto);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            objectOutputStream.writeObject(enviando);

            lista_contiene_palabra = (ArrayList<Documento>) objectInputStream.readObject();

            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return lista_contiene_palabra;
    }
}