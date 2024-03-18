package fr.formation.zoo;

public class SoigneurProZebre implements SoigneurZebre {
    @Override
    public void soigner(Zebre animal) {
        System.out.println("Je soigne le zèbre ... " + animal.getNom());
    }
}
