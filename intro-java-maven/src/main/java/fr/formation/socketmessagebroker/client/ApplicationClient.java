package fr.formation.socketmessagebroker.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.formation.ObjectMapperFactory;
import fr.formation.jsontypicodephotos.Photo;
import fr.formation.jsontypicodephotosproxy.HttpJsonClient;

public class ApplicationClient {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("127.0.0.1", 1234);
            HttpJsonClient httpJsonClient = new HttpJsonClient();
            ObjectMapper mapper = ObjectMapperFactory.createObjectMapper(true);
            
            // On décore notre HttpJsonClient
            httpJsonClient = new HttpClientDecorator(httpJsonClient);
            httpJsonClient = new LogHttpClientDecorator(httpJsonClient);

            Photo photo = httpJsonClient.get("https://jsonplaceholder.typicode.com/photos/1", Photo.class);

            PrintWriter output = new PrintWriter(client.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String xml = mapper.writeValueAsString(photo).replace("\n", "\nall ");

            sendMessageAndWaitResponse("hello", output, input);

            sendMessageAndWaitResponse("all " + xml, output, input);

            sendMessageAndWaitResponse("quit", output, input);
        }

        catch (JsonProcessingException e) {
            System.out.println("Impossible de sérialiser la photo ...");
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
