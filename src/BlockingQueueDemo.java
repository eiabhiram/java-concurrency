import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {

    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

        // Producer
        new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Producing " + i);
                    queue.put(i); // blocks if full
                    Thread.sleep(3000);
                }
            } catch (Exception ignored) {
            }
        }).start();

        // Consumer
        new Thread(() -> {
            try {
                while (true) {
                    Integer value = queue.take(); // blocks if empty
                    System.out.println("Consuming " + value);
                }
            } catch (Exception ignored) {
            }
        }).start();
    }
}
