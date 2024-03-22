package fr.formation.interpretor;

public class Interpretor {
    private Interpretor() { }
    
    public static String evaluate(String value) {
        InterpretorContext context = new InterpretorContext(value);
        HttpExpression httpExpression = new HttpCommandExpression().interpret(context);

        httpExpression.interpret(context);
        
        return new PropertyExpression().interpret(context);
    }
}
