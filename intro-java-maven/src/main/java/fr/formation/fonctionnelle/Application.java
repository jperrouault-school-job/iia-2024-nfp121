package fr.formation.fonctionnelle;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        IfaceFonctionnelle demo1 = new IFaceFonctionnelleImpl();

        demo1.demo();
        demo1.fncDemo();

        // Plutôt que d'avoir une classe qui implémente l'interface
        // On peut chercher la référence d'une méthode
        IfaceFonctionnelle demo2 = Application::methodeReferencee;

        demo2.demo();
        demo2.fncDemo();

        // Ou encore, on peut chercher la référence d'une méthode ... anonyme !
        // Ce qu'on appelle une "Expression Lambda"
        // IfaceFonctionnelle demo3 = () -> {
        //     System.out.println("Expression Lambda !!");
        // };
        IfaceFonctionnelle demo3 = () -> System.out.println("Expression Lambda !!");

        demo3.demo();
        demo3.fncDemo();


        List<String> prenoms = List.of("Enzo", "Yann", "Jérémy", "Aurélien");

        prenoms.forEach((prenom) -> {
            System.out.println(prenom);
        });
        
        prenoms.forEach(prenom -> System.out.println(prenom));

        prenoms.forEach(System.out::println);
    }

    public static void methodeReferencee() {
        System.out.println("Méthode référencée !!!");
    }
}
