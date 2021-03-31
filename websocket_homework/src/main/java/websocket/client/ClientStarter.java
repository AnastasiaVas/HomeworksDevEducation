package websocket.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class ClientStarter {

    public static void main(String[] args) throws URISyntaxException {
        ClientEndpoint client = new ClientEndpoint(new URI("ws://localhost:4141/"));
        while (true) {
            Scanner scanner = new Scanner(System.in);
            client.getUserSession().getAsyncRemote().sendText(scanner.nextLine());
        }
    }
}
