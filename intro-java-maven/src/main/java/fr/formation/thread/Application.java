package fr.formation.thread;

public class Application {
    public static void main(String[] args) {
        demo(0);
        
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e) { }

            demo(1);
        });
        
        new Thread(() -> {
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) { }

            demo(2);
        }).start();
        
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) { }

            demo(3);
        }).start();

        t.start();

        System.out.println("Attente de la fin du programme ...");
    }

    public static void demo(int number) {
        System.out.println("Thread name (" + number + ") : " + Thread.currentThread().getName());
    }
}
