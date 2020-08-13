package thread_base.thread3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author whh
 */
class ConditionBuffer {

    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    private final Object[] items = new Object[5];
    private int putItem, takeItem, count;

    void put(Object obj) throws InterruptedException {
        lock.lock();    //获取锁
        try {
            // 如果“缓冲已满”，则等待；直到“缓冲”不是满的，才将obj添加到缓冲中。
            while (count == items.length) {
                notFull.await();
            }
            // 将obj添加到缓冲中
            items[putItem] = obj;
            // 将“put统计数putItem+1”；如果“缓冲已满”，则设putItem为0。
            if (++putItem == items.length) {
                putItem = 0;
            }
            // 将“缓冲”数量+1
            ++count;
            // 唤醒take线程，因为take线程通过notEmpty.await()等待
            notEmpty.signal();

            // 打印写入的数据
            System.out.println(Thread.currentThread().getName() + " put  " + (Integer) obj);
        } finally {
            lock.unlock();    // 释放锁
        }
    }

    Object take() throws InterruptedException {
        lock.lock();    //获取锁
        try {
            // 如果“缓冲为空”，则等待；直到“缓冲”不为空，才将x从缓冲中取出。
            while (count == 0) {
                notEmpty.await();
            }
            // 将x从缓冲中取出
            Object obj = items[takeItem];
            // 将“take统计数takeItem+1”；如果“缓冲为空”，则设takeItem为0。
            if (++takeItem == items.length) {
                takeItem = 0;
            }
            // 将“缓冲”数量-1
            --count;
            // 唤醒put线程，因为put线程通过notFull.await()等待
            notFull.signal();

            // 打印取出的数据

            System.out.println(Thread.currentThread().getName() + " take " + obj);
            return obj;
        } finally {
            lock.unlock();    // 释放锁
        }
    }
}


