package thread.concurrent01;

/**
 * @Date: 2019/1/21 15:32
 * @Description: interrupt()  中断线程操作
 * @Author admin
 */
public class ConcurrentMain03 {

    public static void main(String[] args) {

        final Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        };

        Thread busyThread = new Thread() {
            @Override
            public void run() {
                while (true) {
                }
            }
        };


        thread.start();
        busyThread.start();

        thread.interrupt();
        busyThread.interrupt();
        while (thread.isInterrupted()) {
        }
        System.out.println("thread isInterrupted: " + thread.isInterrupted());
        System.out.println("busyThread isInterrupted: " + busyThread.isInterrupted());
    }

}
