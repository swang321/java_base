package thread_base.thread3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author whh
 */
public class SemaphoreThread {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            Runnable run = () -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            };
            executorService.execute(run);
        }
        executorService.shutdown();
    }
}
