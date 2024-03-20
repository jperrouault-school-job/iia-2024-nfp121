package fr.formation.jsontypicodephotosproxy;

import java.util.Arrays;
import java.util.List;

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
