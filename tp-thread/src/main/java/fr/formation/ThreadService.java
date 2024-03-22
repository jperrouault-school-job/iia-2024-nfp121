package fr.formation;

public class ThreadService {
    public void noThread() {
        System.out.println("Pas de thread ...");
    }

    public void withThread() {
        try {
            Thread.sleep(2000);
        }
        
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Thread ici " + Thread.currentThread().getName());
    }

    public void withOtherThread() {
        try {
            Thread.sleep(5000);
        }
        
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Autre thread ici " + Thread.currentThread().getName());
    }

    public void execTenTimes() {
        try {
            Thread.sleep(1000);
        }
        
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Exécution toutes les secondes : " + Thread.currentThread().getName());
    }

}
