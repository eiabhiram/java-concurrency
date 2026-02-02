import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueDemo {

    public static void main(String[] args) throws Exception {

        DelayQueue<DelayedTask> queue = new DelayQueue<>();

        queue.put(new DelayedTask("Task-1", 2));
        queue.put(new DelayedTask("Task-2", 5));
        queue.put(new DelayedTask("Task-3", 1));

        while (true) {
            System.out.println("Executing " + queue.take().name);
        }
    }

    static class DelayedTask implements Delayed {

        String name;
        long executeTime;

        DelayedTask(String name, int delaySeconds) {
            this.name = name;
            this.executeTime = System.currentTimeMillis() + delaySeconds * 1000L;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            long diff = executeTime - System.currentTimeMillis();
            return unit.convert(diff, TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed other) {
            return Long.compare(this.executeTime, ((DelayedTask) other).executeTime);
        }
    }
}
