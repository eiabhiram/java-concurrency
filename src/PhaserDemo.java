import java.util.concurrent.Phaser;

public class PhaserDemo {

    public static void main(String[] args) {

        Phaser phaser = new Phaser(3);

        for (int i = 1; i <= 3; i++) {
            new Thread(new Worker("Worker-" + i, phaser)).start();
        }
    }

    static class Worker implements Runnable {

        String name;
        Phaser phaser;

        Worker(String name, Phaser phaser) {
            this.name = name;
            this.phaser = phaser;
        }

        public void run() {
            work("Phase 1");
            phaser.arriveAndAwaitAdvance();

            work("Phase 2");
            phaser.arriveAndAwaitAdvance();

            work("Phase 3");
            phaser.arriveAndAwaitAdvance();
        }

        private void work(String phase) {
            System.out.println(name + " working on " + phase);
            try {
                Thread.sleep((long) (Math.random() * 2000));
            } catch (InterruptedException ignored) {
            }
        }
    }
}
