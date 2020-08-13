package thread;

/**
 * @Date: 2019/1/18 15:39
 * @Description:
 * @Author admin
 */
public class ThreadMain extends Thread {

    public static void main(String[] args) {
        RunnableThread runnableThread = new RunnableThread("+++++++++++++++++++++++++");
        runnableThread.start();
        RunnableThread runnableThread2 = new RunnableThread("-------------------------");
        runnableThread2.start();
    }

    static class RunnableThread implements Runnable {
        private Thread thread;
        private String threadName;

        RunnableThread(String threadName) {
            this.threadName = threadName;
            System.out.println("create: " + threadName);
        }

        @Override
        public void run() {
            System.out.println("Running : " + threadName);
            for (int i = 0; i < 4; i++) {
                System.out.println("thread: " + threadName + "  " + i);
                try {
                    // 让线程睡眠一会
                    Thread.sleep(60);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        /**
         * start  后 run才开始执行
         */
        void start() {
            System.out.println("kaishi: " + threadName);
            if (thread == null) {
                thread = new Thread(this, threadName);
                thread.start();
            }
        }

    }
}
