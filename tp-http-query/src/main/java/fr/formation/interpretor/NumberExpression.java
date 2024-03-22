package fr.formation.interpretor;

public class NumberExpression implements Expression<Integer> {
    @Override
    public Integer interpret(InterpretorContext context) {
        String number = context.getExpressions().remove(0);

        try {
            return Integer.parseInt(number);
        }
        
        catch (NumberFormatException nfe) {
            return 0;
        }
    }
}
