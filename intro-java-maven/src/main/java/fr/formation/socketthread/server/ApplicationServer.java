package fr.formation.socketthread.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ApplicationServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);

            while (true) {
                // Attente de la connexion d'un client ...
                Socket client = server.accept();
                new Thread(() -> interract(client)).start();
            }
        }

        catch (Exception ex) {
            System.out.println("Impossible de créer le serveur ...");
        }
    }

    public static void interract(Socket client) {
        try {
            // Pour envoyer des messages : utiliser la classe PrintWriter avec OuputStreamWriter
            // Pour réceptionner des messages : utiliser la classe BufferedReader avec InputStreamReader

            PrintWriter output = new PrintWriter(client.getOutputStream(), true); // le param true permet un autoflush
            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));

            while (true) {
                // Attente d'un message du client
                String messageClient = input.readLine();
                System.out.println("Le message du client est : " + messageClient);
                
                if (messageClient.equals("hello")) {
                    // Envoyer un message au client
                    output.println("hello client");
                }

                else if (messageClient.equals("quit")) {
                    // Envoyer un message au client
                    output.println("bye");
                    break; // Sortir de la boucle
                }
                
                else {
                    // Envoyer un message au client
                    output.println("command not found");
                }
            }
        }

        catch (Exception ex) {
            System.out.println("Un problème est survenue pendant l'échange avec le client ...");
        }
    } 
}
