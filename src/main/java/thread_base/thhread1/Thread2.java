package thread_base.thhread1;

/**
 * @Author whh
 */
public class Thread2 {

    public static void main(String[] args) {

        MyThread2 t1=new MyThread2();
        MyThread2 t2=new MyThread2();

        t1.start();
        t2.start();
    }
}

class MyThread2 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}