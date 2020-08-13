package thread_base.thread2.sleep;

/**
 * @Author whh
 */
public class SleepThread {

    public static void main(String[] args) {

        Thread t1 = new Thread(new MySleep());
        t1.start();
        for (int i = 0; i < 3; i++) {
            System.out.println("main thread " + i);
        }
    }
}

class MySleep implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("mySleep "+i);
        }
    }
}