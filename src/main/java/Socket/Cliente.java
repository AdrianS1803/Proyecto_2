package Socket;


import Logica.Documento;
import Logica.Mensaje;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 *@author Sebastían Hernández Bonilla y Adrián Salas Solís
 *@version v0.1 octubre 2022
 */
public class Cliente {

    private ArrayList<Documento> lista_contiene_palabra = new ArrayList<>();
    private String Host;
    private int puerto;

    /**
     * Cosntructor del objeto Cliente.
     * @param Host String Es la ip del servidor.
     * @param puerto Integrer Es el puerto al que el cliente se conecta.
     */
    public Cliente(String Host, Integer puerto){
        this.Host = Host;
        this.puerto = puerto;
    }

    /**
     * Manda un mensaje al servidor para que este lo interprete y le devuelva una ArrayList de Documeneto.
     * @param enviando Mensaje es el objeto mensaje que envía al servidor.
     * @return ArrayList<Documento> es la arrayList que devuelve el servidor.
     */
    public ArrayList<Documento> sendMensaje(Mensaje enviando) {
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