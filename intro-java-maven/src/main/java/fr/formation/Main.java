package fr.formation;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Personne personne = Personne.builder()
            .nom("Jérémy")
            .build()
        ;
    }
}