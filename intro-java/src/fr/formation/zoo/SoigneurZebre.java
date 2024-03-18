package fr.formation.zoo;

public class SoigneurZebre implements Soigneur<Zebre> {
    @Override
    public void soigner(Zebre animal) {
        System.out.println("Je soigne le zèbre ... " + animal.getNom());
    }
}
