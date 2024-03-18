package fr.formation.zoo;

public abstract class Soigneur<T extends Animal> {
    public abstract void soigner(T animal);
}
