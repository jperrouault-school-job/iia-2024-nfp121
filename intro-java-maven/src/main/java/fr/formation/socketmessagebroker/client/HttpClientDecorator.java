package fr.formation.socketmessagebroker.client;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.formation.ObjectMapperFactory;
import fr.formation.jsontypicodephotosproxy.HttpJsonClient;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HttpClientDecorator extends HttpJsonClient implements Observable<String> {
    private final HttpJsonClient httpJsonClient;
    private List<Observer<String>> observers = new ArrayList<>();
    private ObjectMapper mapper = ObjectMapperFactory.createObjectMapper(true);

    // public HttpClientDecorator(HttpJsonClient httpJsonClient) {
    //     this.httpJsonClient = httpJsonClient;
    // }

    @Override
    public <T> T get(String url, Class<T> clz) {
        System.out.println("J'suis passé par là");

        T response = this.httpJsonClient.get(url, clz);

        try {
            this.notify(mapper.writeValueAsString(response));
        }

        catch (JsonProcessingException e) {
            System.out.println("Impossible de sérialiser la réponse ...");
        }

        return response;
    }

    @Override
    public void subscribe(Observer<String> observer) {
        this.observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer<String> observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notify(String value) {
        this.observers.forEach(o -> o.update(value));
    }
}
