package thread.concurrent01;

/**
 * @Date: 2019/1/21 15:32
 * @Description: join()  join 方法
 * @Author admin
 */
public class ConcurrentMain04_1 {

    public static void main(String[] args) {

        Thread thread = Thread.currentThread();

        for (int i = 0; i < 10; i++) {
            Thread thread1 = new JoinThread(thread);
            thread1.start();
            thread = thread1;
        }

    }

    static class JoinThread extends Thread {
        private Thread thread;

        public JoinThread(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
                System.out.println(thread.getName() + " terminated.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
