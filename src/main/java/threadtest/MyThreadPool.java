package threadtest;


import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author whh
 */
public class MyThreadPool {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static LinkedBlockingDeque<Runnable> BLOCKINGQUEUE = new LinkedBlockingDeque<>();

    public static ThreadPoolExecutor THREADTASK = new ThreadPoolExecutor(5, 8, 1000, TimeUnit.SECONDS, BLOCKINGQUEUE, r -> {
        Thread thread = new Thread(r);
        thread.setName("task-thread-threadtest-" + atomicInteger.getAndIncrement());
        return thread;
    });

    public static void execute() {

        while (!BLOCKINGQUEUE.isEmpty()) {
            try {
                THREADTASK.execute(BLOCKINGQUEUE.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
