package thread_base.thhread1;

/**
 * @Author whh
 */
public class Thread1 {

    public static void main(String[] args) {

<<<<<<< HEAD
        MyThread1 myThread = new MyThread1();

        Thread t1 = new Thread(myThread);
        Thread t2 = new Thread(myThread);
=======
        MyThread1 myThread=new MyThread1();

        Thread t1=new Thread(myThread);
        Thread t2=new Thread(myThread);
>>>>>>> 61b50b7609c7b8eb97f29dbc145658e6bc2cb979

        t1.start();
        t2.start();


    }

}

<<<<<<< HEAD
class MyThread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
=======
class MyThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
>>>>>>> 61b50b7609c7b8eb97f29dbc145658e6bc2cb979
        }
    }
}