package thread_base.thread2.interrupt;

/**
 * @Author whh
 */
public class InterruptedThread2 {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
        Thread.sleep(1000);

        System.out.println("当前正在执行的线程：" + Thread.currentThread().getName());

        thread.interrupt(); // Thread.currentThread().interrupt();
//        Thread.currentThread().interrupt();

        System.out.println("是否停止？=" + Thread.interrupted());// false，main线程没有被中断
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        int i = 0;
        for (; i < 500000; i++) {
            i++;
        }
        System.out.println("i: " + i);
    }
}