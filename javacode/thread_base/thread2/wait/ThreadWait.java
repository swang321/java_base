package thread_base.thread2.wait;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author whh
 */
public class ThreadWait {

    private static final ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        // 线程state状态空闲，主线程获取到锁
        synchronized (map) {
            for (int i = 0; i < 10; i++) {
                map.put("abc", 123);
                Thread thread = new Thread(new WaitThread1());
                thread.start();
                try {
                    // 启动线程，锁等待，并释放锁，等待子线程锁的通知
                    map.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "----" + (map.get("abc") == 123 ? "获取线程失败--值：" + map.get("abc") : "获取线程成功--值：" + map.get("abc")));
                map.clear();
            }
        }


    }

    static class WaitThread1 implements Runnable {
        @Override
        public void run() {
            // 通过主线程释放锁，锁空闲，子线程得到锁
            synchronized (map) {
                map.put("abc", 123456);
                // 执行完put方法加入map，通知所有正在等待的锁执行，.notify()通知这个锁执行同样，notifyAll()可以提高效率
                ThreadWait.class.notifyAll();
            }
        }
    }


}

