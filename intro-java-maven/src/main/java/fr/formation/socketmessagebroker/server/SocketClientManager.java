package fr.formation.socketmessagebroker.server;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketClientManager {
    private List<SocketClient> clients = new ArrayList<>();

    public void start(Socket socket) {
        SocketClient client = new SocketClient(socket);

        this.clients.add(client);
        new Thread(() -> this.interract(client)).start();
    }

    public void sendToAllExcept(String message, SocketClient except) {
        for (SocketClient client : this.clients) {
            if (client != except) {
                client.send(message);
            }
        }
    }

    public void interract(SocketClient client) {
        while (true) {
            // Attente d'un message du client
            String messageClient = client.waitForInput();
            System.out.println("Le message du client est : " + messageClient);
            
            if (messageClient.equals("hello")) {
                client.send("hello client");
            }

            else if (messageClient.equals("all")) {
                this.sendToAllExcept("Message à tous", client);
            }

            else if (messageClient.equals("quit")) {
                client.send("bye");
                break; // Sortir de la boucle
            }
            
            else {
                client.send("command not found");
            }
        }
    }
}
