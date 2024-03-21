package fr.formation.socketmessagebroker.client;

import fr.formation.jsontypicodephotos.Photo;
import fr.formation.jsontypicodephotosproxy.HttpJsonClient;

public class ApplicationClient {
    public static void main(String[] args) {
        HttpJsonClient httpJsonClient = new HttpJsonClient();
        LogHttpObserver logHttpObserver = new LogHttpObserver();
        SocketHttpObserver socketHttpObserver = new SocketHttpObserver();

        // On décore notre HttpJsonClient
        httpJsonClient = new HttpClientDecorator(httpJsonClient);

        ((HttpClientDecorator)httpJsonClient).subscribe(logHttpObserver);
        ((HttpClientDecorator)httpJsonClient).subscribe(socketHttpObserver);

        httpJsonClient = new LogHttpClientDecorator(httpJsonClient);

        httpJsonClient.get("https://jsonplaceholder.typicode.com/photos/1", Photo.class);
        httpJsonClient.get("https://jsonplaceholder.typicode.com/photos/2", Photo.class);
        httpJsonClient.get("https://jsonplaceholder.typicode.com/photos/3", Photo.class);
    }
}
