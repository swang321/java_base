package thread_base.thread2.wait;

/**
 * @Author whh
 */
public class WaitThread1 {

    public static void main(String[] args) {

        PrintRunnable pr1 = new PrintRunnable();
        Thread thread1 = new Thread(pr1);
        Thread thread2 = new Thread(pr1);

        thread1.start();
        thread2.start();

    }
}

class PrintRunnable implements Runnable {

    int i = 0;

    @Override
    public synchronized void run() {
        while (true) {
            //唤醒等待的线程
            notify();
            if (i < 100) {
                System.out.println(Thread.currentThread().getName() + " : " + i++);
                try {
                    //等待 同时释放锁
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}