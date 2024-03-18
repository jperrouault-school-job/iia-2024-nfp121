package fr.formation.zoo;

public class SoigneurProTigre implements SoigneurTigre {
    @Override
    public void soigner(Tigre animal) {
        System.out.println("Je soigne correctement le titre ... " + animal.getNom());
    }

    @Override
    public void endormir(Tigre tigre) {
        System.out.println("J'endors le tigre ...");
    }

    // @Override
    // public void soigner(Animal animal) {
    //     if (!(animal instanceof Tigre)) {
    //         System.out.println("Je ne peux pas soigner... pas un tigre !");
    //         return;
    //     }

    //     System.out.println("Je soigne le titre ... " + animal.getNom());
    // }
}
