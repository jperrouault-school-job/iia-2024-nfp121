package fr.formation.zoo;

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

        for (int i = 0; i < animaux.length; i++) {
            System.out.println(animaux[i]);
            animaux[i].manger();
        }

        SoigneurZebre soigneurZebre = new SoigneurEtudiantZebre();
        SoigneurTigre soigneurTigre = new SoigneurProTigre();

        soigneurZebre.soigner(albert);
        soigneurTigre.soigner(didier);
        // soigneurZebre.soigner(didier); // Plus possible avec les génériques !
    }
}
