package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Date: 2019/1/21 9:53
 * @Description:
 * @Author admin
 */
public class CreateExecutors01 {

    public static void main(String[] args) {
        createExecutors();
    }


    private static void createExecutors() {
//        1、创建线程池对象
//        2、创建 Runnable 接口子类对象
//        3、提交 Runnable 接口子类对象
//        4、关闭线程池

        //        1、创建线程池对象  参数5，代表有5个线程的线程池
        int maxThreads = 5;
        ExecutorService service = Executors.newFixedThreadPool(maxThreads);

        //        2、创建Runnable线程任务对象
        TaskRunnable taskRunnable = new TaskRunnable();

        //从线程池中获取线程对象
        service.submit(taskRunnable);

        //再获取一个线程对象
        service.submit(taskRunnable);

        //关闭线程池
        service.shutdown();

    }

    static class TaskRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("-----  star :    " + i);
            }
        }
    }


}
