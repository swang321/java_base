package thread_base.thread2.wait.wait3;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @Author whh
 */
public class ShareDataTest {

    public static void main(String[] args) {

        final ShareData sd = new ShareData();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        sd.incrment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"线程AA").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        sd.descment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"线程BB").start();


    }

}
