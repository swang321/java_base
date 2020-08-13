package thread_base.thread2.wait.wait3;

/**
 * @Author whh
 */
public class ShareData {

    private int num = 0;

    //增加数据的方法
    public synchronized void incrment() throws InterruptedException {
        while (num != 0) {
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName() + " : " + num);
        this.notify();
    }

    // 减少数据的方法
    public synchronized void descment() throws InterruptedException {
        while (num == 0) {
            // 等待
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName() + "\t" + num);
        this.notifyAll();
    }
}
