package fr.formation.fonctionnelle;

@FunctionalInterface // Non obligatoire pour que ça fonctionne
// L'annotation permet simplement de vérifier que l'interface réponde aux critères de l'interface fonctionnelle :
// UNE et UNE SEULE signature (sans comportement)
public interface IfaceFonctionnelle {
    public void fncDemo();

    public default void demo() {
        System.out.println("Démonstration de comportement dans l'interface !!");
    }
}
