package fr.formation.fonctionnelle;

import java.util.Arrays;
import java.util.List;

import fr.formation.jsontypicodephotosproxy.HttpJsonClient;
import fr.formation.jsontypicodephotosproxy.Photo;

public class Application {
    public static void main(String[] args) {
        List<String> prenoms = List.of("Enzo", "Yann", "Jérémy", "Aurélien");

        // prenoms.forEach((prenom) -> {
        //     System.out.println(prenom);
        // });
        
        // prenoms.forEach(prenom -> System.out.println(prenom));

        // prenoms.forEach(System.out::println);
        prenoms.stream()
            .filter(prenom -> !prenom.equals("Aurélien"))
            // .map(prenom -> prenom.toUpperCase())
            .map(String::toUpperCase)
            // .forEach(prenom -> System.out.println(prenom))
            .forEach(System.out::println);
        ;


        // Liste des photos
        // On garde les IDS paires < 150
        // On récupère que les titres
        // On les affiche

        List<Photo> photos = Arrays.asList(
            new HttpJsonClient().get("https://jsonplaceholder.typicode.com/photos", Photo[].class)
        );
        
        List<String> titles = photos.stream()
            .filter(p -> (p.getId() < 150) && (p.getId() % 2 == 0))
            // .map(p -> p.getTitle())
            .map(Photo::getTitle)
            .toList()
        ;

        titles.forEach(System.out::println);
    }

    public static void demo() {
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
    }

    public static void methodeReferencee() {
        System.out.println("Méthode référencée !!!");
    }
}
