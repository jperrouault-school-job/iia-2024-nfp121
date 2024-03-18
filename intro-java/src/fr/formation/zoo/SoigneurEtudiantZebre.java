package fr.formation.zoo;

public class SoigneurEtudiantZebre implements SoigneurZebre {
    @Override
    public void soigner(Zebre animal) {
        System.out.println("Je soigne avec grande difficulté le zèbre " + animal.getNom());
    }
}
