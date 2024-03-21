package fr.formation.socketmessagebroker.client;

public interface Observable<T> {
    public void subscribe(Observer<T> observer);
    public void unsubscribe(Observer<T> observer);
    public void notify(T value);
}
