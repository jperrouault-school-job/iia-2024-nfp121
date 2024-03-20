package fr.formation.jsontypicodephotosproxy;

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
            HttpClient httpClient = new HttpClientProxy();
            ObjectMapper mapper = ObjectMapperFactory.createObjectMapper(false);
            
            HttpRequest requestPhotos = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/photos"))
                .GET()
                .build()
            ;

            HttpResponse<byte[]> responsePhotos = httpClient.send(requestPhotos, BodyHandlers.ofByteArray());

            List<Photo> photos = Arrays.asList(mapper.readValue(responsePhotos.body(), Photo[].class));

            for (Photo photo : photos) {
                HttpRequest requestAlbum = HttpRequest.newBuilder()
                    .uri(new URI("https://jsonplaceholder.typicode.com/albums/" + photo.getAlbumId()))
                    .GET()
                    .build()
                ;

                HttpResponse<byte[]> responseAlbum = httpClient.send(requestAlbum, BodyHandlers.ofByteArray());

                Album album = mapper.readValue(responseAlbum.body(), Album.class);

                photo.setAlbumTitle(album.getTitle());
            }

            for (Photo photo : photos) {
                System.out.println(photo.getId() + " - " + photo.getTitle() + " (" + photo.getAlbumTitle() + ")");
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
