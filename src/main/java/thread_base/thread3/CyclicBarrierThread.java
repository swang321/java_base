package thread_base.thread3;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author whh
 */
public class CyclicBarrierThread {

    private static int parties = 3;

    private static CyclicBarrier barrier = new CyclicBarrier(parties);

    public static void main(String[] args) {

        for (int i = 0; i < parties; i++) {
            new Thread(new Tasks()).start();
        }
    }

    static class Tasks implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "await");
            // 在所有参与者都已经在此 barrier 上调用 await 方法之前，将一直等待。
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "continued");
        }
    }

}

