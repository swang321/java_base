package thread.concurrent01;

/**
 * @Date: 2019/1/21 15:32
 * @Description: sleep()  sleep 方法
 * 1. sleep()方法是Thread的静态方法，而wait是Object实例方法
 * 2. wait()方法必须要在同步方法或者同步块中调用，也就是必须已经获得对象锁。   而sleep()方法没有这个限制可以在任何地方种使用。
 * wait()方法会释放占有的对象锁，使得该线程进入等待池中，等待下一次获取资源。而sleep()方法只是会让出CPU并不会释放掉对象锁；
 * 3. sleep()方法在休眠时间达到后如果再次获得CPU时间片就会继续执行，         而wait()方法必须等待Object.notift/Object.notifyAll通知后，
 * 才会离开等待池，并且再次获得CPU时间片才会继续执行。
 * <p>
 * public static native void yield();
 * sleep()方法  与  yield()方法类似
 * @Author admin
 */
public class ConcurrentMain05 extends Thread {

    public static void main(String[] args) {
        Thread thread = new Thread(new ConcurrentMain05());
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        super.run();
    }
}
