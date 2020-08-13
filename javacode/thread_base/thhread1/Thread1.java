package thread_base.thhread1;

/**
 * @Author whh
 */
public class Thread1 {

    public static void main(String[] args) {


        MyThread1 myThread=new MyThread1();

        Thread t1=new Thread(myThread);
        Thread t2=new Thread(myThread);

        t1.start();
        t2.start();


    }

}

class MyThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}