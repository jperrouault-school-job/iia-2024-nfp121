package fr.formation.socketmessagebroker.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
    private Socket socket;
    private PrintWriter output;
    private BufferedReader input;

    public SocketClient(Socket socket) {
        this.socket = socket;

        try {
            this.output = new PrintWriter(this.socket.getOutputStream(), true); // le param true permet un autoflush
            this.input = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        }
        
        catch (IOException e) {
            System.out.println("Impossible de créer l'input / output ...");
        }
    }

    public String waitForInput() {
        try {
            return this.input.readLine();
        }
        
        catch (Exception e) {
            System.out.println("Impossible de lire l'input ...");
            return "";
        }
    }

    public void send(String message) {
        this.output.println(message);
    }
}
