package aarandom;

/**
 * @Author whh  2019/8/15 15:29
 */
public class Test3 {

    int k = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread1 t1 = new Thread1();
        Thread1 t2 = new Thread1();
        t1.start();
        t2.start();
//        Thread.sleep(1000);
//        t1.join();
//        t2.join();

        Thread.yield();

        System.out.println("结束---------------------------");
    }
}

class Thread1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
        }
    }
}