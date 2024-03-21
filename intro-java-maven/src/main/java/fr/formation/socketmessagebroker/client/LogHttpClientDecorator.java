package fr.formation.socketmessagebroker.client;

import fr.formation.jsontypicodephotosproxy.HttpJsonClient;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LogHttpClientDecorator extends HttpJsonClient {
    private final HttpJsonClient httpJsonClient;

    @Override
    public <T> T get(String url, Class<T> clz) {
        System.out.println("Je journalise ........");
        return this.httpJsonClient.get(url, clz);
    }
}
