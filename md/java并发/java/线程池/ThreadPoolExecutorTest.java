package 线程池;


import java.util.concurrent.*;

/**
 * @Author whh  2019/11/11 15:49
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {

        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());


//        int corePoolSize,
//        int maximumPoolSize,
//        long keepAliveTime,
//        TimeUnit unit,
//        BlockingQueue<Runnable> workQueue,
//        ThreadFactory threadFactory

        ThreadPoolExecutor executor = new ThreadPoolExecutor
                (1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), r -> {
                    Thread thread = new Thread(r);
                    thread.setName("thread_task_name");
                    return thread;
                });

        Thread.interrupted();



        Executors.newFixedThreadPool(2);
        //  new ThreadPoolExecutor(nThreads, nThreads,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>())

        Executors.newSingleThreadExecutor();
        //  new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>())

        Executors.newCachedThreadPool();
        //  new ThreadPoolExecutor(0, Integer.MAX_VALUE,60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>()

        Executors.newScheduledThreadPool(2);
        //  new ScheduledThreadPoolExecutor(corePoolSize)

        //     public ScheduledThreadPoolExecutor(int corePoolSize) {
        //        super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS,
        //              new DelayedWorkQueue());
        //    }

        Executors.newWorkStealingPool();

    }

}

