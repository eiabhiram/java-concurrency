package Bonus_ThreadLocal;

public class ThreadLocalDemo {

    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {

        Runnable task = () -> {
            int value = threadLocal.get();
            value += 1;
            threadLocal.set(value);

            System.out.println(Thread.currentThread().getName() + " value = " + threadLocal.get());
        };

        new Thread(task, "Thread-A").start();
        new Thread(task, "Thread-B").start();
        new Thread(task, "Thread-C").start();
        new Thread(task, "Thread-D").start();
        new Thread(task, "Thread-E").start();
        new Thread(task, "Thread-F").start();

    }
}
