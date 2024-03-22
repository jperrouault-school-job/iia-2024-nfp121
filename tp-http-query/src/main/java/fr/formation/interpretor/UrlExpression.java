package fr.formation.interpretor;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UrlExpression implements Expression<String> {
    private final TypeExpression typeExpression;
    private final NumberExpression numberExpression;

    @Override
    public String interpret(InterpretorContext context) {
        String type = this.typeExpression.interpret(context).getSimpleName();
        Integer id = this.numberExpression.interpret(context);
        
        if (type.equalsIgnoreCase("photo")) {
            return "https://jsonplaceholder.typicode.com/photos/" + id;
        }

        if (type.equalsIgnoreCase("album")) {
            return "https://jsonplaceholder.typicode.com/albums/" + id;
        }

        return null;
    }
}
