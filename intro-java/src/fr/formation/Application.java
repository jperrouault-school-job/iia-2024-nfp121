package fr.formation;

public class Application {
    public static void main(String[] args) {
        System.out.println("!!! Le nom des classes, des interfaces : CamelCase");
        System.out.println("!!! Le nom des attributs, méthodes, variables : lowerCamelCase");

        Integer a = 5; // Objet
        int b = 6; // Valeur


        System.out.println("Le résultat est convertit en String : " + a + b);
        System.out.println("Le résultat est : " + (a + b));
        
        Object babar = new Personne();

        ((Personne)babar).getClass(); // cast
        // ((Boolean)babar).getClass(); // cast impossible

        System.out.println("La personne est : " + babar);
    }
}
