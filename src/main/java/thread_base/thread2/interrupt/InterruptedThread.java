package thread_base.thread2.interrupt;

/**
 * @Author whh
 */
public class InterruptedThread {
    public static void main(String[] args) {

        Interrupted thread1=new Interrupted();



    }
}

class Interrupted extends Thread {

    @Override
    public void run() {
        int i = 0;
        while (!isInterrupted()) {
            try {
                Thread.sleep(100);
                i++;
                System.out.println(Thread.currentThread().getName() + " state  " + Thread.currentThread().getState() + " : " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("exception: " + Thread.currentThread().getName() + " state  " + Thread.currentThread().getState());
            }
        }
    }

}
