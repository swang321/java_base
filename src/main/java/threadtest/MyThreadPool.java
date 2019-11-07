package threadtest;


<<<<<<< HEAD
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
=======
>>>>>>> 61b50b7609c7b8eb97f29dbc145658e6bc2cb979
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author whh
 */
<<<<<<< HEAD

@Component
public class MyThreadPool {

    private static final Logger log = LoggerFactory.getLogger(MyThreadPool.class);

=======
public class MyThreadPool {

>>>>>>> 61b50b7609c7b8eb97f29dbc145658e6bc2cb979
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static LinkedBlockingDeque<Runnable> BLOCKINGQUEUE = new LinkedBlockingDeque<>();

<<<<<<< HEAD
    public static ThreadPoolExecutor THREADTASK = new ThreadPoolExecutor(2, 5, 10, TimeUnit.SECONDS, BLOCKINGQUEUE, r -> {
=======
    public static ThreadPoolExecutor THREADTASK = new ThreadPoolExecutor(5, 8, 1000, TimeUnit.SECONDS, BLOCKINGQUEUE, r -> {
>>>>>>> 61b50b7609c7b8eb97f29dbc145658e6bc2cb979
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
<<<<<<< HEAD
    }

    @PreDestroy
    public void shutDown() {
        THREADTASK.shutdown();
        while (true) {
            try {
                if (THREADTASK.awaitTermination(1, TimeUnit.SECONDS)) {
                    break;
                }
                log.info("线程还在执行！剩余任务：" + THREADTASK.getQueue().size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("转化匹配线程已停止......");
=======

>>>>>>> 61b50b7609c7b8eb97f29dbc145658e6bc2cb979
    }


}
