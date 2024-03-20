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

public class ApplicationHttpJson {
    public static void main(String[] args) {
        HttpJsonClient httpClient = new HttpJsonClient();
        
        List<Photo> photos = Arrays.asList(httpClient.get("https://jsonplaceholder.typicode.com/photos", Photo[].class));

        for (Photo photo : photos) {
            Album album = httpClient.get("https://jsonplaceholder.typicode.com/albums/" + photo.getAlbumId(), Album.class);

            photo.setAlbumTitle(album.getTitle());
        }

        for (Photo photo : photos) {
            System.out.println(photo.getId() + " - " + photo.getTitle() + " (" + photo.getAlbumTitle() + ")");
        }
    }
}
