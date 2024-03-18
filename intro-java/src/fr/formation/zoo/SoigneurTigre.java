package fr.formation.zoo;

public class SoigneurTigre extends Soigneur {
    @Override
    public void soigner(Animal animal) {
        if (!(animal instanceof Tigre)) {
            System.out.println("Je ne peux pas soigner... pas un tigre !");
            return;
        }

        System.out.println("Je soigne le titre ... " + animal.getNom());
    }
}
