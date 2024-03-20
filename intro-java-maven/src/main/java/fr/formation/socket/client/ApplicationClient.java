package fr.formation.socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ApplicationClient {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("127.0.0.1", 1234);

            PrintWriter output = new PrintWriter(client.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));

            output.println("Bonjour, voici le message du client !");

            String messageServer = input.readLine();
            System.out.println("La réponse du serveur : " + messageServer);
        }
        
        catch (UnknownHostException e) {
            System.out.println("Nom d'hôte incorrect ...");
        }
        
        catch (IOException e) {
            System.out.println("Impossible de se connecter ... Le serveur est-il lancé ?");
        }
    }
}
