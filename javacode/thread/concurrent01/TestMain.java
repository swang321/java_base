package thread.concurrent01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author whh
 */


public class TestMain {

    private static volatile int count = 0;

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(new Runnable() {
                Lock lock = new ReentrantLock();

                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        count++;
                    }
                }
            });
            thread.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);

    }

}


