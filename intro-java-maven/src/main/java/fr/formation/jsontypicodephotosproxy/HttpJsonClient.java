package fr.formation.jsontypicodephotosproxy;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.formation.ObjectMapperFactory;

public class HttpJsonClient {
    private HttpClient httpClient = new HttpClientProxy();
    private ObjectMapper mapper = ObjectMapperFactory.createObjectMapper(false);

    public <T> T get(String url, Class<T> clz) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build()
            ;

            HttpResponse<byte[]> response = httpClient.send(request, BodyHandlers.ofByteArray());
            
            return mapper.readValue(response.body(), clz);
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

        return null;
    }
}
