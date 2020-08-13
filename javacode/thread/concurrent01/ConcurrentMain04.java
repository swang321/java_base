package thread.concurrent01;

/**
 * @Date: 2019/1/21 15:32
 * @Description: join()  join 方法
 * @Author admin
 */
public class ConcurrentMain04 {

    public static class MyThread extends Thread {
        @Override
        public void run() {

            try {
                int m = (int) (Math.random() * 10000);
                System.out.println("我在子线程中会随机睡上0-9秒，时间为=" + m);
                Thread.sleep(m);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 如果一个线程实例A执行了threadB.join(),其含义是：当前线程A会等待threadB线程终止后threadA才会继续执行
     */
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.join();
        System.out.println("正常情况下肯定是我先执行完，但是加入join后，main主线程会等待子线程执行完毕后才执行");
    }

}
