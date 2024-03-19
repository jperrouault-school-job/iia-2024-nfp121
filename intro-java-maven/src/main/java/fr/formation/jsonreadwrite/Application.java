package fr.formation.jsonreadwrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.formation.ObjectMapperFactory;
import fr.formation.Personne;

public class Application {
    public static void main(String[] args) {
        // write();
        read();
    }

    public static void write() {
        List<Personne> personnes = new ArrayList<>();
        ObjectMapper mapper = ObjectMapperFactory.createObjectMapper(false);

        personnes.add(Personne.builder()
            .nom("FERREIRA GOMES")
            .prenom("Enzo")
            .build()
        );

        personnes.add(Personne.builder()
            .nom("STEUNOU")
            .prenom("Yann")
            .build()
        );

        try {
            byte[] json = mapper.writeValueAsBytes(personnes);
            File file = new File("personnes.json");

            try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
                fileOutputStream.write(json);
            }
        }
        
        catch (JsonProcessingException e) {
            System.out.println("Impossible de sérialiser la liste ...");
        }
        
        catch (Exception e) {
            System.out.println("Impossible d'écrire le fichier ...");
        }
    }

    public static void read() {
        File file = new File("personnes.json");

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] json = fileInputStream.readAllBytes();
            ObjectMapper mapper = ObjectMapperFactory.createObjectMapper(false);

            List<Personne> personnes = Arrays.asList(mapper.readValue(json, Personne[].class));

            for (Personne personne : personnes) {
                System.out.println("Nom : " + personne.getNom() + ", prénom : " + personne.getPrenom());
            }
        }

        catch (FileNotFoundException ex) {
            System.out.println("Le fichier n'existe pas.");
        }

        catch (IOException ex) {
            System.out.println("Impossible de lire le contenu ...");
        }
    }
}
