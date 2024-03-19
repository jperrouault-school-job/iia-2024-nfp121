package fr.formation.readwrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        File file = new File("hello.txt");
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(file);
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

        finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                }
                
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
