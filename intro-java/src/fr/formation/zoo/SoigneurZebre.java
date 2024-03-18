package fr.formation.zoo;

public class SoigneurZebre extends Soigneur<Zebre> {
    @Override
    public void soigner(Zebre animal) {
        System.out.println("Je soigne le zèbre ... " + animal.getNom());
    }
}
