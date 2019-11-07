package java_some.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author whh  2019/8/8 16:44
 */
public class NewSingleThreadExecutorTest {

    public static void main(String[] args) {
        //创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newSingleThreadExecutor();

        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();

        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);

        pool.shutdown();

    }
}

