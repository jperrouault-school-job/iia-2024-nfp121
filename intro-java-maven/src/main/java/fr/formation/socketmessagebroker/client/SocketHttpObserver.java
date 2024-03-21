package fr.formation.socketmessagebroker.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketHttpObserver implements Observer<String> {
    private Socket socket = null;
    private PrintWriter output = null;

    @Override
    public void update(String value) {
        if (this.socket == null) {
            try {
                this.socket = new Socket("127.0.0.1", 1234);
                this.output = new PrintWriter(this.socket.getOutputStream(), true);
            }
            
            catch (IOException e) {
                System.out.println("Impossible de se connecter au serveur ...");
            }
        }

        value = value.replace("\n", "\nall ");
        this.output.println("all " + value);
    }
}
