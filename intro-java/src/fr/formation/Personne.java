package fr.formation;

public class Personne {
    public void parler() {
        System.out.println("La personne parle ...");
    }

    @Override
    public String toString() {
        String stringMere = super.toString(); // Rappeler le toString de la première classe mère qui a cette méthode
        return stringMere + " - Babar";
    }
}
