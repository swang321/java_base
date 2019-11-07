package thread_base.thread2.wait;

/**
 * @Author whh
 */
public class WaitThread2 {

    public static void main(String[] args) {

        Tickets tickets = new Tickets();

        Thread t1 = new Thread(tickets);
        Thread t2 = new Thread(tickets);
        Thread t3 = new Thread(tickets);

        t1.start();
        t2.start();
        t3.start();
    }
}

class Tickets implements Runnable {
    int i = 100;
    Object object = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (object) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i > 0) {
                    System.out.println(Thread.currentThread().getName() + " : " + i--);
                }
            }
        }
    }
}
