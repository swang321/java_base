package thread.demo01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Date: 2019/1/21 11:42
 * @Description:
 * @Author admin
 */
public class LockThreadMain {

    public static void main(String[] args) {

        TaskRunnable taskRunnable = new TaskRunnable();
        Thread thread = new Thread(taskRunnable);
        thread.start();


        TaskRunnable taskRunnable2 = new TaskRunnable();
        Thread thread2 = new Thread(taskRunnable2);
        thread2.start();

    }


    static class TaskRunnable implements Runnable {
        /**
         * 共享数据
         */
        int ticket = 100;
        Lock lock = new ReentrantLock();

        @Override
        public void run() {

            //在可能出现线程安全问题的代码前,调用Lock接口中的方法lock获取锁对象
            lock.lock();
            try {

                Thread.sleep(10);
                while (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票!");
                    ticket--;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //一定会执行的代码,一般用于资源释放(资源回收)
                //在可能出现线程安全问题的代码后,调用Lock接口中的方法unlock释放锁对象
                //论程序是否有异常,都让锁对象释放掉,节约内存,提高程序的效率
                lock.unlock();
            }

        }
    }


}
