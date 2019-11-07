package java_some.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author whh  2019/8/8 16:54
 */
public class NewCacheThreadPoolTest {

    public static void main(String[] args) {
        //创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newCachedThreadPool();

        for (int i = 0; i < 50; i++) {
            pool.execute(new MyThread());
        }

        pool.shutdown();

    }

}
