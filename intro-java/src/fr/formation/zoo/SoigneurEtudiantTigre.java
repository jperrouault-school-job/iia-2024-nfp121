package fr.formation.zoo;

public class SoigneurEtudiantTigre implements SoigneurTigre {

    @Override
    public void soigner(Tigre animal) {
        System.out.println("Je soigne difficilement le titre " + animal.getNom());
    }

    @Override
    public void endormir(Tigre tigre) {
        System.out.println("J'arrive pas à endormir le tigre ...");
    }
}
