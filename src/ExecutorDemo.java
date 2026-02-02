import java.util.concurrent.Executor;

public class ExecutorDemo {

    public static void main(String[] args) {

        Executor sameThreadExecutor = r -> r.run();
        Executor newThreadExecutor = r -> new Thread(r).start();

        System.out.println("Main thread: " + Thread.currentThread().getName());

        sameThreadExecutor.execute(() -> System.out.println("Task thread: " + Thread.currentThread().getName()));
        newThreadExecutor.execute(() -> System.out.println("Task2 thread: " + Thread.currentThread().getName()));

    }
}
