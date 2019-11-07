package thread_base.thread3;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author whh
 */
public class LockSupportThreadMain {

    public static void main(String[] args) {

<<<<<<< HEAD
        Thread thread = Thread.currentThread();
=======
        Thread thread=Thread.currentThread();
>>>>>>> 61b50b7609c7b8eb97f29dbc145658e6bc2cb979
        LockSupport.unpark(thread);
        LockSupport.park();
        System.out.println("ASdasd");

    }

}
