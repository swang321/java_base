
**ConcurrentMain02** 线程新建三种方式:

     1. 通过继承Thread类，重写run方法；
     2. 通过实现runable接口；
     3. 通过实现callable接口这三种方式，
**ConcurrentMain03** 中断线程:

        interrupted()   对当前线程进行中断操作，该方法会清除中断标志位。. 
                        测试 当前线程 是否已经是中断状态，执行后具有清除状态功能。
**ConcurrentMain04**  等待
        
     join()     join底层是wait方法，所以它是会释放对象锁的，
                而sleep在同步的方法中是不释放对象锁的，只有同步方法执行完毕，其他线程才可以执行。

**ConcurrentMain05**   睡眠    

    sleep()     * 1. sleep()方法是Thread的静态方法，而wait是Object实例方法
                * 2. wait()方法必须要在同步方法或者同步块中调用，也就是必须已经获得对象锁。   而sleep()方法没有这个限制可以在任何地方种使用。
                *    wait()方法会释放占有的对象锁，使得该线程进入等待池中，等待下一次获取资源。而sleep()方法只是会让出CPU并不会释放掉对象锁；
                * 3. sleep()方法在休眠时间达到后如果再次获得CPU时间片就会继续执行，         而wait()方法必须等待Object.notift/Object.notifyAll通知后，
                *    才会离开等待池，并且再次获得CPU时间片才会继续执行。
                * public static native void yield();
                * sleep()方法  与  yield()方法类似     
                
**ConcurrentMain06**    守护线程
    
    Daemon()     谁设置为守护线程谁就是左后一个退出线程的， 守护线程退出了，
                 其他线程无论执行完还是没有执行完 都退出，GC垃圾回收 经典应用       
 

synchronized 是一种悲观所策略              
JMM happens-before规则     CAS(compare and swap) 乐观锁策略    

     volatile   synchronized    
     
     synchronized: 具有原子性，有序性和可见性*        
     volatile：具有有序性和可见性**      