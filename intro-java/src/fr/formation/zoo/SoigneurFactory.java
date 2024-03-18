package fr.formation.zoo;

public class SoigneurFactory {
    private SoigneurFactory() { } // Empêcher l'instanciation depuis l'extérieur de la classe

    public static SoigneurZebre createSoigneurZebre() {
        return new SoigneurEtudiantZebre();
    }

    public static SoigneurTigre createSoigneurTigre() {
        return new SoigneurProTigre();
    }
}
