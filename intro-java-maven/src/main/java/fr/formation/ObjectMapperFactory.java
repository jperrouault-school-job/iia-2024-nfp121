package fr.formation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ObjectMapperFactory {
    private ObjectMapperFactory() { }

    public static ObjectMapper createObjectMapper(boolean xml) {
        ObjectMapper mapper = xml ? new XmlMapper() : new ObjectMapper();

        // Ajout du module JSR310 (API JAVA 8 - Date et Heure)
        mapper.registerModule(new JavaTimeModule());

        // On ajoute le format "Pretty"
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        return mapper;
    }
}
