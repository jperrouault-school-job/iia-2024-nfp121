package fr.formation.socketmessagebroker.server;

import java.net.ServerSocket;

public class ApplicationServer {
    public static void main(String[] args) {
        SocketClientManager manager = new SocketClientManager();

        try (ServerSocket server = new ServerSocket(1234)) {
            while (true) {
                // Attente de la connexion d'un client ...
                manager.start(server.accept());
            }
        }

        catch (Exception ex) {
            System.out.println("Impossible de créer le serveur ...");
        }
    }
}
