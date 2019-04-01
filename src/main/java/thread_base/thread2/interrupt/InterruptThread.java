package thread_base.thread2.interrupt;

/**
 * @Author whh
 */
public class InterruptThread {

    public static void main(String[] args) {

        Thread thread = new Thread(new Interrupt());
        thread.start();
        thread.interrupt();

        System.out.println("第一次调用thread.isInterrupted()：" + thread.isInterrupted());
        System.out.println("第二次调用thread.isInterrupted()：" + thread.isInterrupted());
        System.out.println("thread是否存活：" + thread.isAlive());




    }


}

class Interrupt implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
        }
    }
}