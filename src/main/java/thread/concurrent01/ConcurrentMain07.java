package thread.concurrent01;

/**
 * @Description: synchronized  关键子
 * @Author admin
 */
public class ConcurrentMain07 {
    private static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SynThread());
            thread.start();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    static class SynThread implements Runnable {
        @Override
        public void run() {
            synchronized (SynThread.class) {
                for (int i = 0; i < 10000; i++) {
                    count++;
                }
            }
        }
    }


}
