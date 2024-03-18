package fr.formation.zoo;

public interface Soigneur<T extends Animal> {
    public void soigner(T animal);
}
