package fr.formation.interpretor;

import fr.formation.model.Album;
import fr.formation.model.Photo;

public class TypeExpression implements Expression<Class<?>> {
    @Override
    public Class<?> interpret(InterpretorContext context) {
        String type = context.getExpressions().remove(0);

        if (type.equalsIgnoreCase("photo")) {
            context.setType(Photo.class);
        }

        if (type.equalsIgnoreCase("album")) {
            context.setType(Album.class);
        }

        return context.getType();
    }
}
