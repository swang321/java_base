package thread_base.thread2.interrupt;

/**
 * @Author whh
 */
public class IsInterruptedThread3 {
    public static void main(String[] args) throws InterruptedException {
        MyThread3 thread = new MyThread3();
        thread.start();
        //Thread.sleep(1000);

        System.out.println("当前正在执行的线程：" + Thread.currentThread().getName());

        thread.interrupt();

        System.out.println("是否停止？=" + thread.isInterrupted());// false，main线程没有被中断
    }
}

class MyThread3 extends Thread {
    @Override
    public void run() {
        int i = 0;
        super.run();
        for (; i < 500000; i++) {
            i++;
        }
        System.out.println("i: " + i);
    }
}