import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(2); // Only 2 threads can access at the same time
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 5; i++) {
            int id = i;
            executor.submit(() -> access(id, semaphore));
        }

        executor.shutdown();
    }

    private static void access(int id, Semaphore semaphore) {
        try {
            System.out.println("Task " + id + " waiting");
            semaphore.acquire();
            System.out.println("Task " + id + " acquired");
            Thread.sleep(2000);
        } catch (Exception ignored) {
        } finally {
            semaphore.release();
            System.out.println("Task " + id + " released");
        }
    }
}
