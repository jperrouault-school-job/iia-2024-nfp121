package fr.formation.socket.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ApplicationServer {
    public static void main(String[] args) {
        // Création d'un ServerSocket qui va écouter sur un port spécifique

        // Ecouter les connexions des clients
        // Ecouter les messages des clients
        // Envoyer des messages aux clients

        try {
            ServerSocket server = new ServerSocket(1234);

            // Attente de la connexion d'un client ...
            Socket client = server.accept();

            // Pour envoyer des messages : utiliser la classe PrintWriter avec OuputStreamWriter
            // Pour réceptionner des messages : utiliser la classe BufferedReader avec InputStreamReader

            PrintWriter output = new PrintWriter(client.getOutputStream(), true); // le param true permet un autoflush
            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));

            // Attente d'un message du client
            String messageClient = input.readLine();
            System.out.println("Le message du client est : " + messageClient);

            // Envoyer un message au client
            output.println("OK");
        }

        catch (Exception ex) {
            System.out.println("Impossible de créer le serveur ...");
        }
    }
}
