package thread;

/**
 * @Date: 2019/1/18 14:33
 * @Description:
 * @Author admin
 */
public class RunnableMain {
    public static void main(String[] args) {
        RunnableThread runnable = new RunnableThread("thread-one");
        runnable.start();
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
                    Thread.sleep(50);
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
