package thread_base.thread3;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author whh
 */
public class LockSupportThreadMain {

    public static void main(String[] args) {

        Thread thread=Thread.currentThread();
        LockSupport.unpark(thread);
        LockSupport.park();
        System.out.println("ASdasd");

    }

}
