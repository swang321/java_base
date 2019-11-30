## java 并发

#### AQS  AbstractQueuedSynchronizer

    getState()：返回同步状态的当前值；
    setState(int newState)：设置当前同步状态；
    compareAndSetState(int expect, int update)：使用CAS设置当前状态，该方法能够保证状态设置的原子性；
    tryAcquire(int arg)：独占式获取同步状态，获取同步状态成功后，其他线程需要等待该线程释放同步状态才能获取同步状态；
    tryRelease(int arg)：独占式释放同步状态；
    tryAcquireShared(int arg)：共享式获取同步状态，返回值大于等于0则表示获取成功，否则获取失败；
    tryReleaseShared(int arg)：共享式释放同步状态；
    isHeldExclusively()：当前同步器是否在独占式模式下被线程占用，一般该方法表示是否被当前线程所独占；
    acquire(int arg)：独占式获取同步状态，如果当前线程获取同步状态成功，则由该方法返回，否则，将会进入同步队列等待，该方法将会调用可重写的tryAcquire(int arg)方法；
    acquireInterruptibly(int arg)：与acquire(int arg)相同，但是该方法响应中断，当前线程为获取到同步状态而进入到同步队列中，如果当前线程被中断，则该方法会抛出InterruptedException异常并返回；
    tryAcquireNanos(int arg,long nanos)：超时获取同步状态，如果当前线程在nanos时间内没有获取到同步状态，那么将会返回false，已经获取则返回true；
    acquireShared(int arg)：共享式获取同步状态，如果当前线程未获取到同步状态，将会进入同步队列等待，与独占式的主要区别是在同一时刻可以有多个线程获取到同步状态；
    acquireSharedInterruptibly(int arg)：共享式获取同步状态，响应中断；
    tryAcquireSharedNanos(int arg, long nanosTimeout)：共享式获取同步状态，增加超时限制；
    release(int arg)：独占式释放同步状态，该方法会在释放同步状态之后，将同步队列中第一个节点包含的线程唤醒；
    releaseShared(int arg)：共享式释放同步状态；

CLH 同步队列
 
CLH同步队列中，一个节点表示一个线程，它保存着线程的引用（thread）、状态（waitStatus）、前驱节点（prev）、后继节点（next）


### 等待/通知的经典范式

#### 等待方遵循如下原则。

1）获取对象的锁。

2）如果条件不满足，那么调用对象的wait()方法，被通知后仍要检查条件。

3）条件满足则执行对应的逻辑

    synchronized(对象) {
        while(条件不满足) {
            对象.wait();
        }
        对应的处理逻辑
    }
    
#### 通知方遵循如下原则。

1）获得对象的锁。

2）改变条件。

3）通知所有等待在对象上的线程。

    synchronized(对象) {
        改变条件
        对象.notifyAll();
    }



### 避免死锁的常见方法

1避免一个线程同时获取多个锁

2避免一个线程在锁内同时占用多个资源，尽量保证每个锁只占用一个资源。

3尝试使用定时锁，使用lock.tryLock（timeout）来替代使用内部锁机制。

4对于数据库锁，加锁和解锁必须在一个数据库连接里，否则会出现解锁失败的情况





 