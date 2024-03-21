package fr.formation.socketmessagebroker.client;

public interface Observer<T> {
    public void update(T value);
}
