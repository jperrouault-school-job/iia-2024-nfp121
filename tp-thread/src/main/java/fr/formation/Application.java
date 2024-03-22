package fr.formation;

public class Application {
    public static void main(String[] args) {
        ThreadService service = new ThreadServiceProxy();

        service.noThread();
        service.withThread();
        service.withOtherThread();
        
        service.execTenTimes();
    }
}
