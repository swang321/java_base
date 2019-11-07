package thread.concurrent01.waitnotify;

import java.util.concurrent.TimeUnit;

/**
 * @Author whh
 */
public class OrderMain {

    public static void main(String[] args) {

        final OrderProcess orderProcess = new OrderProcess();

        //生产
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    orderProcess.addOrder(new Order());
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();

        //消费
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    try {
                        orderProcess.getOrder();
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

}
