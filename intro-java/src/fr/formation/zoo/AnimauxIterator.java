package fr.formation.zoo;

public class AnimauxIterator implements Iterator<Animal> {
    private Animal[] animaux;
    private int index;

    public AnimauxIterator(Animal[] animaux) {
        this.animaux = animaux;
    }

    @Override
    public boolean hasNext() {
        return index < animaux.length;
    }

    @Override
    public Animal next() {
        return this.animaux[this.index++];
    }
}
