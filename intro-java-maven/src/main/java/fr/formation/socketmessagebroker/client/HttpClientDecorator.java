package fr.formation.socketmessagebroker.client;

import fr.formation.jsontypicodephotosproxy.HttpJsonClient;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HttpClientDecorator extends HttpJsonClient {
    private final HttpJsonClient httpJsonClient;

    // public HttpClientDecorator(HttpJsonClient httpJsonClient) {
    //     this.httpJsonClient = httpJsonClient;
    // }

    @Override
    public <T> T get(String url, Class<T> clz) {
        System.out.println("J'suis passé par là");
        return this.httpJsonClient.get(url, clz);
    }
}
