package fr.formation.exception;

public class Application {
    public static void main(String[] args) {
        // 3 types d'Exception en Java
        // > Exception "Checked" : elles sont obligatoirement gérées dans le code
        // > Exception "Unchecked" : elles ne sont pas obligatoirement gérées dans le code
        // > Error : généralement, on peut pas les anticiper et l'application va crasher

        // Toute exception dérive d'une classe Throwable

        try { // Permet de tenter l'exécution
            System.out.println("Tentative Checked Exception ...");
            demoCheckedException();
            System.out.println("C'est OK !");
        }

        catch (CustomCheckedException ex) { // Permet de gérer une nature d'exception de type CustomCheckedException
            System.out.println("Gestion de la CustomCheckedException ...");
        }

        catch (Exception ex) { // Permet de gérer une nature d'exception
            System.out.println("Oups");
        }

        finally { // Permet d'exécuter un ensemble d'instructions dans tous les cas (erreur ou pas)
            // S'exécute avant un "return" présent dans le try / catch
            System.out.println("Fin de la tentative !");
        }

        System.out.println("Avant Unchecked Exception ...");
        demoUncheckedException();
        System.out.println("Après Unchecked Exception ...");
    }

    // Le throws prévient les programmes appelant que potentiellement, on a une exception de type Exception
    public static void demoCheckedException() throws Exception {
        // Le throw permet de jeter une instance d'exception
        // throw new Exception();
        throw new CustomCheckedException();
    }

    public static void demoUncheckedException() {
        // throw new RuntimeException();
        throw new CustomUncheckedException();
    }
}
