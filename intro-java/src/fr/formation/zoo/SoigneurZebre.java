package fr.formation.zoo;

public class SoigneurZebre extends Soigneur {
    @Override
    public void soigner(Animal animal) {
        if (!(animal instanceof Zebre)) {
            System.out.println("Je ne peux pas soigner... pas un zèbre !");
            return;
        }

        System.out.println("Je soigne le zèbre ... " + animal.getNom());
    }
}
