package fr.formation.zoo;

public class AnimauxIterator implements Iterator<Animal> {
    private static AnimauxIterator instance;
    private Animal[] animaux;
    private int index;

    private AnimauxIterator(Animal[] animaux) {
        this.animaux = animaux;
    }

    public static AnimauxIterator getInstance(Animal[] animaux) {
        if (instance == null) {
            instance = new AnimauxIterator(animaux);
        }

        return instance;
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
