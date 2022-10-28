package Socket;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;

/**
 *@author Sebastían Hernández Bonilla y Adrián Salas Solís
 *@version v0.1 octubre 2022
 */
public class RunServer {
    /**
     * Inicia el servidor
     * @param args
     * @throws IOException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws ClassNotFoundException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws InvalidFormatException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvalidFormatException {
        Server server = new Server(9000);
        server.iniciar();

    }
}
