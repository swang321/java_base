package java_some.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Author whh  2019/8/8 16:58
 */
public class NewScheduledThreadPool {

    public static void main(String[] args) {

//        ScheduledExecutorService pool = new ScheduledThreadPoolExecutor(1);
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService pool = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    }

}
//    ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
//            .setNameFormat("demo-pool-%d").build();
//    ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
//            0L, TimeUnit.MILLISECONDS,
//            new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
//
//    singleThreadPool.execute(()-> System.out.println(Thread.currentThread().getName()));
//            singleThreadPool.shutdown();
//
//
//
//public class TimerTaskThread extends Thread {
//    public TimerTaskThread(){
//        super.setName("TimerTaskThread"); …
//    }