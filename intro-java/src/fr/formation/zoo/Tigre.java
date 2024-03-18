package fr.formation.zoo;

public class Tigre extends Animal {
    public Tigre() { }

    public Tigre(String nom) {
        super(nom);
    }

    @Override
    public String toString() {
        return "Tigre " + this.nom; // this.nom dispo car "protected"
    }

    @Override
    public void manger() {
        System.out.println("Le tigre mange ...");
    }
}
