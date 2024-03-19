package fr.formation.readwrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        File file = new File("hello.txt");

        // Le "try-with-resource" va automatiquement appeler la méthode "close" à la fin du try
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] content = fileInputStream.readAllBytes();
            String contentString = new String(content);

            System.out.println("Le contenu est : " + contentString);
        }
        
        catch (FileNotFoundException e) {
            System.out.println("Le fichier n'existe pas !");
        }
        
        catch (IOException e) {
            System.out.println("Impossible de lire le contenu ...");
        }
    }
}
