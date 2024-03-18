package fr.formation.zoo;

public class Zebre extends Animal {
    public Zebre() { }

    public Zebre(String nom) {
        super(nom);
    }

    @Override
    public String toString() {
        return "Zèbre " + this.nom;
    }

    @Override
    public void manger() {
        System.out.println("Le zèbre mange ...");
    }
}
