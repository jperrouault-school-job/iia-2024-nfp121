package fr.formation.xml;

import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import fr.formation.Personne;

public class Application {
    public static void main(String[] args) {
        Personne jeremy = Personne.builder()
            .nom("PERROUAULT")
            .prenom("Jérémy")
            // Année, Mois, Jour
            .dateNaissance(LocalDate.of(1987, 11, 2))
            .build()
        ;

        // Sérialisation : passer de l'objet Java en "texte"
        XmlMapper mapper = new XmlMapper();

        // Ajout du module JSR310 (API JAVA 8 - Date et Heure)
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            String result = mapper.writeValueAsString(jeremy);
            System.out.println("Le résultat est : " + result);
        }
        
        catch (JsonProcessingException e) {
            System.out.println("Impossible de sérialiser l'objet ...");
        }
    }
}
