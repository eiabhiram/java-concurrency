import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<String> future = executor.submit(() -> {
            Thread.sleep(2000);
            return "Hello from Future";
        });

        System.out.println("Doing other work...");

        System.out.println("Result: " + future.get());

        executor.shutdown();
    }
}
