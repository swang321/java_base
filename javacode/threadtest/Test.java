package threadtest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Author whh
 */
public class Test {

    public static void main(String[] args) {

        ExecutorService service = Executors.newSingleThreadExecutor();
        ExecutorService service1 = Executors.newCachedThreadPool();
        ExecutorService service2 = Executors.newFixedThreadPool(3);
        ExecutorService service3 = Executors.newWorkStealingPool();
        ScheduledExecutorService service4 = Executors.newScheduledThreadPool(3);
        ScheduledExecutorService service5 = Executors.newSingleThreadScheduledExecutor();

        Long time = 60L;
        System.out.println(time);

    }

}
