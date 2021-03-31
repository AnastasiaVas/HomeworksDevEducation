package websocket.client;

import javax.websocket.*;
import java.net.URI;

@javax.websocket.ClientEndpoint
public class ClientEndpoint {
    private static Session userSession = null;

    public ClientEndpoint(URI endpointURI) {
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, endpointURI);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Session getUserSession() {
        return userSession;
    }

    @OnOpen
    public void onOpen(Session userSession) {
        ClientEndpoint.userSession = userSession;
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        System.out.println(message);
    }

    @OnClose
    public void onClose(Session session) {
    }
}
