package Socket;

import java.io.IOException;

public class RunServer {
    public static void main(String[] args) throws IOException {
        Server server = new Server(9000);
        server.iniciar();

    }
}
