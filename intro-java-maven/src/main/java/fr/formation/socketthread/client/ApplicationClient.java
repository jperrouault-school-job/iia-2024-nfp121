package fr.formation.socketthread.client;

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
            String response = null;

            response = sendMessageAndWaitResponse("hello", output, input);
            System.out.println("La réponse du serveur : " + response);

            response = sendMessageAndWaitResponse("existe pas", output, input);
            System.out.println("La réponse du serveur : " + response);

            response = sendMessageAndWaitResponse("quit", output, input);
            System.out.println("La réponse du serveur : " + response);
        }
        
        catch (UnknownHostException e) {
            System.out.println("Nom d'hôte incorrect ...");
        }
        
        catch (IOException e) {
            System.out.println("Impossible de se connecter ... Le serveur est-il lancé ?");
        }
    }

    public static String sendMessageAndWaitResponse(String message, PrintWriter output, BufferedReader input) {
        // Envoi du message
        output.println(message);

        try {
            return input.readLine();
        }
        
        catch (IOException e) {
            System.out.println("Impossible de récupérer le message du serveur ...");
            return "";
        }
    }
}
