package Socket;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;

public class RunServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvalidFormatException {
        Server server = new Server(9000);
        server.iniciar();

    }
}
