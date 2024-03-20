package fr.formation.http;

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
                .uri(new URI("https://www.google.fr"))
                .GET()
                .build()
            ;

            HttpClient httpClient = HttpClient.newBuilder().build();
            HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());

            System.out.println("Le résultat est : " + response.body());
        }

        catch (URISyntaxException ex) {
            System.out.println("L'URI spécifiée est incorrecte.");
        }

        catch (Exception ex) {
            System.out.println("Problème lors de l'exécution de la requête ...");
        }
    }
}
