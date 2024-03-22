package fr.formation.interpretor;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HttpGetExpression extends HttpExpression {
    protected final UrlExpression urlExpression;

    @Override
    public String interpret(InterpretorContext context) {
        context.setObject(this.httpJsonClient.get(this.urlExpression.interpret(context), context.getType()));

        return null;
    }
}
