package fr.formation.interpretor;

import java.lang.reflect.Field;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.formation.HttpJsonClient;
import fr.formation.ObjectMapperFactory;

public class PropertyExpression implements Expression<String> {
    protected final HttpJsonClient httpJsonClient = new HttpJsonClient();
    protected final ObjectMapper mapper = ObjectMapperFactory.createObjectMapper();

    @Override
    public String interpret(InterpretorContext context) {
        String property = context.getExpressions().isEmpty() ? null : context.getExpressions().remove(0);
        
        if (property == null) {
            try {
                return mapper.writeValueAsString(context.getObject());
            }

            catch (Exception ex) {
                System.out.println("Impossible de sérialiser l'objet ...");
                return "";
            }
        }

        try {
            String fieldName = (property.equals("image")) ? "thumbnailUrl" : property;
            Field field = context.getType().getDeclaredField(fieldName);
            
            field.setAccessible(true);

            String result = field.get(context.getObject()).toString();

            if (property.equals("image")) {
                return mapper.writeValueAsString(this.httpJsonClient.get(result));
            }

            return result;
        }
        
        catch (JsonProcessingException e) {
            System.out.println("Impossible de sérialiser " + property);
            return "";
        }
        
        catch (Exception e) {
            System.out.println("Impossible de lire la propriété " + property);
            return "";
        }
    }
}
