import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {

    public static void main(String[] args) throws Exception {

        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(() -> service("User", 2, latch));
        executor.submit(() -> service("Order", 3, latch));
        executor.submit(() -> service("Notification", 1, latch));

        System.out.println("Waiting for services...");
        latch.await();
        System.out.println("All services ready!");

        executor.shutdown();
    }

    private static void service(String name, int sec, CountDownLatch latch) {

        try {
            Thread.sleep(sec * 1000L);
            System.out.println(name + " service ready");
        } catch (Exception ignored) {
        } finally {
            latch.countDown();
        }
    }
}
