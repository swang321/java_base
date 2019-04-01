package thread_base.thread2.yield;

/**
 * @Author whh
 */
public class YieldThread {

    public static void main(String[] args) {

        MyThread4A t4A=new MyThread4A();
        MyThread4B t4B=new MyThread4B();
        Thread t1=new Thread(t4A);
        Thread t2=new Thread(t4B);

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
    }

}

class MyThread4A implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("MyThread4A  "+i);
            Thread.yield();
        }
    }
}


class MyThread4B implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("MyThread4B  "+i);
            Thread.yield();
        }
    }
}
