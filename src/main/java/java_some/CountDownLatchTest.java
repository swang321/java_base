package java_some;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @Author whh  2019/8/8 9:36
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {

//        CountDownLatch countDownLatch = new CountDownLatch(10);

        int workCount = 10;
        CountDownLatch countDownLatch1 = new CountDownLatch(1);
        CountDownLatch countDownLatch2 = new CountDownLatch(workCount);
        System.out.println(new Date() + " - Boss：集合准备开工了！");

        for (int i = 0; i < workCount; i++) {
            new Worker(i, countDownLatch1, countDownLatch2).start();
        }
        System.out.println(new Date() + " - Boss：休息2s后开工!");
        Thread.sleep(2000);
        //打开开关
        countDownLatch1.countDown();
        //任务完成后通知Boss

        // 等待所有任务完成  再执行 下面  System.out.println  语句
        countDownLatch2.await();
        System.out.println(new Date() + " - Boss：不错!任务都完成了！收工回家！");
    }

}

class Worker extends Thread {

    private int workNo;

    /**
     * 启动器 闭锁
     */
    private CountDownLatch startLatch;
    /**
     * 工作进程  计数器
     */
    private CountDownLatch endLatch;

    public Worker(int workNo, CountDownLatch startLatch, CountDownLatch endLatch) {
        this.workNo = workNo;
        this.startLatch = startLatch;
        this.endLatch = endLatch;
    }

    @Override
    public void run() {

        System.out.println(new Date() + " - YHJ" + workNo + " 准备就绪！准备开工！");
        try {
            //等待老板发指令
            startLatch.await();
            System.out.println(new Date() + " - YHJ" + workNo + " 正在干活...");
            //每人花100ms干活
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(new Date() + " - YHJ" + workNo + " 工作完成!");
            endLatch.countDown();
        }


    }
}