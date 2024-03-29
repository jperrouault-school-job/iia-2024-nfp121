package fr.formation.zoo;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // Zebre albert = new Zebre();
        // Zebre bernard = new Zebre();
        // Tigre cecile = new Tigre();
        // Tigre didier = new Tigre();
        // Animal animal = new Animal(); // Ne fonctionne plus car abstraite
        
        // albert.setNom("Albert");
        // bernard.setNom("Bernard");
        // cecile.setNom("Cécile");
        // didier.setNom("Didier");


        Zebre albert = new Zebre("Albert");
        Zebre bernard = new Zebre();
        Tigre cecile = new Tigre("Cécile");
        Tigre didier = new Tigre("Didier");

        bernard.setNom("Bernard");

        Animal[] animaux = { albert, bernard, cecile, didier };

        // for (int i = 0; i < animaux.length; i++) {
        //     System.out.println(animaux[i]);
        //     animaux[i].manger();
        // }

        // AnimauxIterator animauxIterator = new AnimauxIterator(animaux);
        AnimauxIterator animauxIterator = AnimauxIterator.getInstance(animaux);

        while (animauxIterator.hasNext()) {
            Animal animal = animauxIterator.next();
            System.out.println(animal);
            animal.manger();
        }

        List<Animal> animauxListe = new ArrayList<>();

        animauxListe.add(albert);
        animauxListe.add(bernard);
        animauxListe.add(cecile);
        animauxListe.add(didier);

        for (Animal animal : animauxListe) {
            System.out.println(animal);
            animal.manger();
        }

        // SoigneurZebre soigneurZebre = new SoigneurEtudiantZebre();
        // SoigneurTigre soigneurTigre = new SoigneurProTigre();
        SoigneurZebre soigneurZebre = SoigneurFactory.createSoigneurZebre();
        SoigneurTigre soigneurTigre = SoigneurFactory.createSoigneurTigre();

        soigneurZebre.soigner(albert);
        soigneurTigre.soigner(didier);
        // soigneurZebre.soigner(didier); // Plus possible avec les génériques !
    }
}
