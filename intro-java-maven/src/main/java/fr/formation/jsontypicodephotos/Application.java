package fr.formation.jsontypicodephotos;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.formation.ObjectMapperFactory;

public class Application {
    public static void main(String[] args) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/photos"))
                .GET()
                .build()
            ;

            HttpClient httpClient = HttpClient.newBuilder().build();
            HttpResponse<byte[]> response = httpClient.send(request, BodyHandlers.ofByteArray());
            ObjectMapper mapper = ObjectMapperFactory.createObjectMapper(false);

            List<Photo> photos = Arrays.asList(mapper.readValue(response.body(), Photo[].class));

            for (Photo photo : photos) {
                System.out.println(photo.getTitle());
            }
        }

        catch (URISyntaxException ex) {
            System.out.println("L'URI spécifiée est incorrecte.");
        }

        catch (JsonParseException e) {
            System.out.println("Impossible de désérialiser le flux ...");
        }

        catch (Exception e) {
            System.out.println("Impossible de récupérer le flux ...");
        }
    }
}
