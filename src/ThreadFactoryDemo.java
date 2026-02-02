import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadFactoryDemo {

    public static void main(String[] args) {

        ThreadFactory factory = new CustomThreadFactory("worker");

        ExecutorService executor = Executors.newFixedThreadPool(3, factory);

        for (int i = 1; i <= 6; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " running on " + Thread.currentThread().getName());
                sleep(1000);
            });
        }

        executor.shutdown();
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    static class CustomThreadFactory implements ThreadFactory {

        private final AtomicInteger counter = new AtomicInteger(1);
        private final String prefix;

        CustomThreadFactory(String prefix) {
            this.prefix = prefix;
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setName(prefix + "-thread-" + counter.getAndIncrement());
            t.setDaemon(false);

            System.out.println("Created " + t.getName());
            return t;
        }
    }
}
