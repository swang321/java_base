package thread.concurrent01;

/**
 * @Date: 2019/1/22 14:43
 * @Description: Daemon() 方法   守护线程
 * @Author admin
 */
public class ConcurrentMain06 {


    public static void main(String[] args) {

        Thread thread = new MyCommon();
        Thread daemonThread = new MyDaemon();
        //  daemonThread 设置守护线程   等待 thread 线程执行完毕后  守护线程就退出了，无论执行完还是没有执行完 都退出
        //  守护线程 守护 其他得线程 完成执行 ，自己是最后退出得一个
        //  GC垃圾回收 经典应用
        daemonThread.setDaemon(true);

        daemonThread.start();
        thread.start();

    }

    static class MyCommon extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + "线程1第" + i + "次执行！");
                    Thread.sleep(7);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            super.run();
        }
    }


    static class MyDaemon extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("后台线程第" + i + "次执行！");
                    Thread.sleep(7);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            super.run();
        }
    }
}
