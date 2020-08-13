package thread_base.thread2.sleep;

/**
 * @Author whh
 */
public class SleepThread1 {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new MySleep1());
        t1.start();

//        MySleep1.sleep(5000);

        System.out.println("当前运行的线程: "+Thread.currentThread().getName());
        for (int i = 0; i < 3; i++) {
            System.out.println("main thread "+i);
        }
    }
}

class MySleep1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {

            System.out.println("MySleep1 "+i);
        }
    }
}