package Socket;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {
    /*public static void main(String[] args){
        final String Host = "192.168.5.171"; //ipconfig en el cmd
        final int puerto = 9000;

        DataOutputStream salida;
        DataInputStream entrada;

        try {
            Socket socket = new Socket(Host,puerto);

            entrada = new DataInputStream(socket.getInputStream());
            salida = new DataOutputStream(socket.getOutputStream());

            salida.writeUTF("Hola mundo desde el cliente");//Manda el mensaje al server
            //Entro al server
            String mensaje = entrada.readUTF();//Ya es el mensaje del server

            System.out.println(mensaje);

            socket.close();




        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }*/
    private String Host;
    private int puerto;


    public Cliente(String Host, Integer puerto){
        this.Host = Host;
        this.puerto = puerto;
    }

    public String send(String enviando){
        DataOutputStream salida;
        DataInputStream entrada;
        String mensaje;

        try {
            Socket socket = new Socket(Host,puerto);

            entrada = new DataInputStream(socket.getInputStream());
            salida = new DataOutputStream(socket.getOutputStream());

            salida.writeUTF(enviando);//Manda el mensaje al server
            //Entro al server
            mensaje = entrada.readUTF();//Ya es el mensaje del server


            //System.out.println(mensaje);

            socket.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return mensaje;
    }
}