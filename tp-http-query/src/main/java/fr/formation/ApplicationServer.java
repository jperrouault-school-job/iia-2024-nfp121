package fr.formation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import fr.formation.interpretor.Interpretor;

public class ApplicationServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(1234)) {
            Socket client = server.accept();

            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter output = new PrintWriter(client.getOutputStream(), true);

            output.println("Hello client! Write your expression here.");

            while (true) {
                String expression = input.readLine();

                if (expression.equalsIgnoreCase("quit")) {
                    output.println("Bye!");
                    break;
                }

                try {
                    output.println(Interpretor.evaluate(expression));
                }

                catch (Exception e) {
                    output.println("Can't evaluate expression ...");
                }
            }
        }

        catch (SecurityException ex) {
            System.out.println("Un problème de sécurité est survenu ...");
        }

        catch (IllegalArgumentException ex) {
            System.out.println("Le port n'est pas correct.");
        }

        catch (Exception ex) {
            System.out.println("OK ...");
        }
    }
}