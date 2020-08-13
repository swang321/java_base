package thread_base.thread3;

import java.util.concurrent.TimeUnit;

/**
 * @Author whh
 */
public class SellTickets {

    public static void main(String[] args) {
        TicketWindow tw = new TicketWindow();

        Thread t1 = new Thread(tw, "一号窗口");
        Thread t2 = new Thread(tw, "二号窗口");

        t1.start();
        t2.start();
    }
}

class TicketWindow implements Runnable {

    private int ticket = 1;

    @Override
    public synchronized void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "还剩余票:" + ticket + "张");
                ticket--;
                System.out.println(Thread.currentThread().getName() + "卖出一张火车票,还剩" + ticket + "张");
            } else {
                System.out.println(Thread.currentThread().getName() + "余票不足,暂停出售!");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}