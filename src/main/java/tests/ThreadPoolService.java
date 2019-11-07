package tests;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ThreadPoolService
 * @Description 线程池管理类
 * @Author haiLuo
 * @Date 2019/5/20 11:04
 * @Version 1.0
 */
@Component
public class ThreadPoolService {
    private static final ThreadPoolExecutor TRANS_DATA_MATCH_EXECUTOR = new ThreadPoolExecutor(4, 8, 30, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadFactory() {
        private AtomicInteger atomicInteger = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setName("TRANS-MATCH-" + atomicInteger.getAndIncrement());
            return t;
        }
    });

    public static void execute(Runnable task) {
        TRANS_DATA_MATCH_EXECUTOR.execute(task);
    }

    @PreDestroy
    public void shutDown() {
        TRANS_DATA_MATCH_EXECUTOR.shutdown();
        while (true) {
            try {
                if (TRANS_DATA_MATCH_EXECUTOR.awaitTermination(1, TimeUnit.SECONDS)) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
