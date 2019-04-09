# java_basic 

1   线程安全

#### 在Java多线程编程当中，实现线程安全：

1. 内部锁（Synchronized）和显式锁（Lock）：属于互斥同步方法，是重量级的多线程同步机制，可能会引起上下文切换和线程调度，它同时提供内存可见性、有序性和原子性。
2. volatile：轻量级多线程同步机制，不会引起上下文切换和线程调度。仅提供内存可见性、有序性保证，不提供原子性。
3. CAS原子指令：属于非阻塞同步方法，轻量级多线程同步机制，不会引起上下文切换和线程调度。它同时提供内存可见性、有序性和原子化更新保证。

#### synchronized锁与volatile变量的比较

volatile变量最大的优点是使用方便。在某些情形下，使用volatile变量要比使用相应的synchronized锁简单得多。
某些情况下，volatile变量同步机制的性能要优于synchronized锁。
volatile变量不会像synchronized锁一样造成阻塞。
volatile变量最大的缺点在于使用范围有限，而且容易出错。


#### 锁概述

##### Lock  
    Lock实现提供了比使用synchronized方法和语句可获得的更广泛的锁定操作。  

##### AbstractOwnableSynchronizer/AbstractQueuedSynchronizer/AbstractQueuedLongSynchronizer 
    AbstractQueuedSynchronizer就是被称之为AQS的类为实现依赖于先进先出 (FIFO) 等待队列的阻塞锁和相关同步器（信号量、事件，等等）提供一个框架

#####   Condition 
    Condition又称等待条件，它实现了对锁更精确的控制 Condition中的await()方法相当于Object的wait()方法，
    Condition中的signal()方法相当于Object的notify()方法，Condition中的signalAll()相当于Object的notifyAll()方法。
    不同的是，Object中的wait(),notify(),notifyAll()方法是和synchronized组合使用的；而Condition需要与Lock组合使用。

#####   ReentrantReadWriteLock 
    ReentrantReadWriteLock维护了一对相关的锁，一个用于只读操作，另一个用于写入操作。

#####   LockSupport 
    用来创建锁和其他同步类的基本线程阻塞原语。

#####   CountDownLatch         
    一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。

#####   CyclicBarrier 
    一个同步辅助类，它允许一组线程互相等待，直到到达某个公共屏障点。

#####   Semaphore  
    一个计数信号量。从概念上讲，信号量维护了一个许可集。Semaphore通常用于限制可以访问某些资源的线程数目。
    
#####   AQS，AbstractQueuedSynchronizer的缩写    
    AQS支持两种资源访问方式，独占模式（Exclusive）和共享模式（Share）




#####   Lock与ReentrantLock
synchronized为隐式锁，而使用Lock时则相反，所以一般称Lock为显示锁
Lock实现比synchronized更灵活
ReentrantLock是一个可重入的互斥锁
ReentrantLock既可以是公平锁又可以是非公平锁

#####   AQS

#####   Condition
精细地控制线程的休眠与唤醒的。

#####   ReentrantReadWriteLock
ReentrantReadWriteLock是支持与ReentrantLock 类似语义的ReadWriteLock实现。
ReadWriteLock维护了两个锁，读锁和写锁,写锁是独占的。读锁是共享的
共享数据很大，且读操作远多于写操作的情况下，读写锁值得一试。
特性:    公平性
        重入性
        锁降级
        锁获取中断
        支持Condition
        检测系统状态

#####   LockSupport
LockSupport的park()和unpark()方法分别用于阻塞线程和解除阻塞线程

#####   StampedLock

#####   CountDownLatch
CountDownLatch是一个通用同步器，用于同步一个或多个任务。在完成一组正在其他线程中执行的任务之前，它允许一个或多个线程一直等待。
启动 关闭开关

#####   CyclicBarrier
允许一组线程互相等待，直到到达某个公共屏障点。如果你希望一组并行的任务在下个步骤之前相互等待，直到所有的任务都完成了下个步骤前的所有操作，才继续向前执行，那么CyclicBarrier很合适

#####   Semaphore
一般的锁在任意时刻只允许一个线程访问一项资源，而计数信号量允许n个任务同时访问一项资源。我们可以将信号量看做一个许可集，可以向线程分发使用资源的许可证。获得资源前，线程调用acquire()从许可集中获取许可。该线程结束后，通过release()将许可还给许可集。