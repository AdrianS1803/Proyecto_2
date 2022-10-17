package Socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    /*public static void main(String[] args){
        ServerSocket server = null;
        Socket socket = null;
        int puerto = 9000;

        DataOutputStream salida;
        DataInputStream entrada;

        //BufferedReader entrada;

        try {
            server = new ServerSocket(puerto);
            System.out.println("Cliente conectado");

            while (true){
                socket = server.accept();

                entrada = new DataInputStream(socket.getInputStream());
                salida = new DataOutputStream(socket.getOutputStream());

                String mensaje = entrada.readUTF();

                System.out.println(mensaje);

                salida.writeUTF("Server: "+mensaje);

                socket.close();
                System.out.println("Cliente desconectado");
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }*/
    private int puerto;
    private ServerSocket server = null;
    private Socket socket = null;

    public Server(Integer puerto){
        this.puerto = puerto;
    }
    public void iniciar(){
        DataOutputStream salida;
        DataInputStream entrada;

        //BufferedReader entrada;

        try {
            server = new ServerSocket(puerto);
            System.out.println("Cliente conectado");

            while (true){
                socket = server.accept();

                entrada = new DataInputStream(socket.getInputStream());
                salida = new DataOutputStream(socket.getOutputStream());

                String mensaje = entrada.readUTF();

                System.out.println(mensaje);

                salida.writeUTF("Server: "+ mensaje);

                socket.close();
                System.out.println("Cliente desconectado");
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }

}