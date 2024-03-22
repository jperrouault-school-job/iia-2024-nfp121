package fr.formation.interpretor;

public class HttpCommandExpression implements Expression<HttpExpression> {
    @Override
    public HttpExpression interpret(InterpretorContext context) {
        String command = context.getExpressions().remove(0);

        if (command.equalsIgnoreCase("get")) {
            return new HttpGetExpression(new UrlExpression(new TypeExpression(), new NumberExpression()));
        }

        return null;
    }
}
