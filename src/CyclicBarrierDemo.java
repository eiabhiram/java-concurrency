import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("---- Phase complete ----"));

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 3; i++) {
            executor.submit(new Worker("Worker-" + i, barrier));
        }

        executor.shutdown();
    }

    static class Worker implements Runnable {

        private final String name;
        private final CyclicBarrier barrier;

        Worker(String name, CyclicBarrier barrier) {
            this.name = name;
            this.barrier = barrier;
        }

        public void run() {
            try {
                phase("Load");
                barrier.await();
                phase("Validate");
                barrier.await();
                phase("Process");
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void phase(String phase) throws InterruptedException {
            System.out.println(name + " - " + phase);
            Thread.sleep((long) (Math.random() * 2000));
        }
    }
}
