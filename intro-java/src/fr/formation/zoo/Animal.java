package fr.formation.zoo;

// Classe abstraite est une classe "non terminée"
public abstract class Animal {
    protected String nom;

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Animal() { }

    public Animal(String nom) {
        this.nom = nom;
    }

    public abstract void manger();
}
