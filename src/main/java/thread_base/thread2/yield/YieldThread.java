package thread_base.thread2.yield;

/**
 * @Author whh
 */
public class YieldThread {

    public static void main(String[] args) {

<<<<<<< HEAD
        MyThread4A t4A = new MyThread4A();
        MyThread4B t4B = new MyThread4B();
        Thread t1 = new Thread(t4A);
        Thread t2 = new Thread(t4B);
=======
        MyThread4A t4A=new MyThread4A();
        MyThread4B t4B=new MyThread4B();
        Thread t1=new Thread(t4A);
        Thread t2=new Thread(t4B);
>>>>>>> 61b50b7609c7b8eb97f29dbc145658e6bc2cb979

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
    }

}

<<<<<<< HEAD
class MyThread4A implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("MyThread4A  " + i);
=======
class MyThread4A implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("MyThread4A  "+i);
>>>>>>> 61b50b7609c7b8eb97f29dbc145658e6bc2cb979
            Thread.yield();
        }
    }
}


<<<<<<< HEAD
class MyThread4B implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("MyThread4B  " + i);
=======
class MyThread4B implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("MyThread4B  "+i);
>>>>>>> 61b50b7609c7b8eb97f29dbc145658e6bc2cb979
            Thread.yield();
        }
    }
}
