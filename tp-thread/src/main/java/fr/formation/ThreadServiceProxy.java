package fr.formation;

public class ThreadServiceProxy extends ThreadService {
    private final ThreadService threadService = new ThreadService();

    @Override
    public void withThread() {
        new Thread(this.threadService::withThread).start();
    }
    
    @Override
    public void withOtherThread() {
        new Thread(this.threadService::withOtherThread).start();
    }

    @Override
    public void execTenTimes() {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                this.threadService.execTenTimes();
            }
        })
        .start();
    }
}
