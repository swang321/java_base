package thread_base.thread3;

import java.util.concurrent.CountDownLatch;

/**
 * @Author whh
 */
public class CountDownLatchThread {

    public static void main(String[] args) throws InterruptedException {
        int n = 5;
        //启动信号，它会阻止所有的worker继续执行。
        CountDownLatch startSignal = new CountDownLatch(1);
        // 完成信号， worker之前一直等待。
        CountDownLatch doneSignal = new CountDownLatch(n);

        for (int i = 0; i < n; i++) {
            new Thread(new Worker(startSignal, doneSignal)).start();
        }
        Thread.sleep(1);
        startSignal.countDown();    // 打开startSignal开关，执行所有等待的任务
        doneSignal.await();         // 等待doneSignal计数器为0，即所有任务执行完
        System.out.println("done");
    }
}

class Worker implements Runnable {

    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "启动了");
            startSignal.await();
            System.out.println(Thread.currentThread().getName() + "工作了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            doneSignal.countDown();
        }
    }
}
