package thread_base.thread2.sleep;

/**
 * @Author whh
 */
public class SleepThread1 {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new MySleep1());
        t1.start();

//        MySleep1.sleep(5000);
        Thread.sleep(5000);
<<<<<<< HEAD
        System.out.println("当前运行的线程: " + Thread.currentThread().getName());
        for (int i = 0; i < 3; i++) {
            System.out.println("main thread " + i);
=======
        System.out.println("当前运行的线程: "+Thread.currentThread().getName());
        for (int i = 0; i < 3; i++) {
            System.out.println("main thread "+i);
>>>>>>> 61b50b7609c7b8eb97f29dbc145658e6bc2cb979
        }
    }
}

class MySleep1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
<<<<<<< HEAD
            System.out.println("MySleep1 " + i);
=======
            System.out.println("MySleep1 "+i);
>>>>>>> 61b50b7609c7b8eb97f29dbc145658e6bc2cb979
        }
    }
}