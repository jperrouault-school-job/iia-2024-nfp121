package fr.formation.httpimage;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Application {
    public static void main(String[] args) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://assets.stickpng.com/images/580b57fcd9996e24bc43c51f.png"))
                .GET()
                .build()
            ;

            HttpClient httpClient = HttpClient.newBuilder().build();
            HttpResponse<byte[]> response = httpClient.send(request, BodyHandlers.ofByteArray());

            File file = new File("google.png");
            
            try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
                fileOutputStream.write(response.body());
            }
        }

        catch (URISyntaxException ex) {
            System.out.println("L'URI spécifiée est incorrecte.");
        }

        catch (Exception ex) {
            System.out.println("Problème lors de l'exécution de la requête ...");
        }
    }
}
