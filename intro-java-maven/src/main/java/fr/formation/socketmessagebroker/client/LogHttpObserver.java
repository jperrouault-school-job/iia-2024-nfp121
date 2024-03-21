package fr.formation.socketmessagebroker.client;

public class LogHttpObserver implements Observer<String> {
    @Override
    public void update(String value) {
        System.out.println("[JOURNAL] " + value);
    }
}
