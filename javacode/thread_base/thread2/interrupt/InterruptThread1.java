package thread_base.thread2.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @Author whh
 */
public class InterruptThread1 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Interrupt1(), "CountThread");
        thread.start();
        //  睡眠1秒，main线程对CountThread进行中断，使CountThread能够感知中断而结束    Thread.sleep(1000);
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
        System.out.println("是否停止1：" + thread.isInterrupted());


        Interrupt1 interrupt1 = new Interrupt1();
        Thread thread1 = new Thread(interrupt1, "CountThread2");
        thread1.start();
        TimeUnit.SECONDS.sleep(1);
        interrupt1.cancel();
        System.out.println("是否停止1：" + thread1.isInterrupted());

    }


    static class Interrupt1 implements Runnable {

        private long i;

        private volatile boolean flag = true;

        @Override
        public void run() {
            while (flag) {
                i++;
            }
            System.out.println("Count i = " + i);
        }

        public void cancel() {
            flag = false;
        }
    }

}