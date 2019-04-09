# java_basic 

#####   juc线程池
    
    Executor,CompletionService,Future,Callable


#####   创建线程池
    
    源码:
    public ThreadPoolExecutor(int corePoolSize,                 //核心池大小 private volatile int corePoolSize; 
                              int maximumPoolSize,              //最大池大小 private volatile int maximumPoolSize;
                              long keepAliveTime,               //是池中线程空闲时的活动时间
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,//线程池工作模型中的阻塞队列，用于传输和保持提交的任务
                              ThreadFactory threadFactory,      //是一个线程集合。线程池可以使用ThreadFactory创建新线程
                              RejectedExecutionHandler handler  //是线程池拒绝策略，RejectedExecutionHandler类型的对象 
                              ) {
        if (corePoolSize < 0 ||
            maximumPoolSize <= 0 ||
            maximumPoolSize < corePoolSize ||
            keepAliveTime < 0)
            throw new IllegalArgumentException();
        if (workQueue == null || threadFactory == null || handler == null)
            throw new NullPointerException();
        this.acc = System.getSecurityManager() == null ?
                null :
                AccessController.getContext();
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.workQueue = workQueue;
        this.keepAliveTime = unit.toNanos(keepAliveTime);
        this.threadFactory = threadFactory;
        this.handler = handler;
    }

#####   handler是线程池拒绝策略
    1   ThreadPoolExecutor.AbortPolicy ，默认策略，处理程序遭到拒绝将抛出运行时 RejectedExecutionException。
    2   ThreadPoolExecutor.CallerRunsPolicy，线程调用运行该任务的 execute 本身。此策略提供简单的反馈控制机制，能够减缓新任务的提交速度。
    3   ThreadPoolExecutor.DiscardPolicy，不能执行的任务将被删除。
    4   ThreadPoolExecutor.DiscardOldestPolicy，如果执行程序尚未关闭，则位于工作队列头部的任务将被删除，然后重试执行程序（如果再次失败，则重复此过程）。

#####   排队策略
    1   SynchronousQueue    它将任务直接传输给工作队列workers，而不保持任务。如果不存在空闲线程，则会新建一个线程来执行任
    2   LinkedBlockingQueue 有界队列，使用此队列会导致在所有corePoolSize线程都忙时新任务在队列中等待。这样，创建的线程就不会超过corePoolSize 
    3   ArrayBlockingQueue 有界队列

#####   线程池状态
RUNNING、SHUTDOWN、STOP、TIDYING、TERMINATED五种状态

#####   关闭线程池
    shutdown(),shutdownNow()

    shutdown()
    1.获取独占锁 
    2.如果有安全管理器，使用安全管理器检查当前线程是否有权限关闭线程池，如果没有权限则抛出SecurityException。 
    3.将线程池状态设为SHUTDOWN。一旦将线程池状态设为SHUTDOWN，就不能像线程池中添加新任务了。 
    4.中断所有空闲线程 
    5.钩子函数，没有执行任何操作 
    6.释放锁 
    7.将线程池状态设置为TERMINATED

    shutdownNow()
    1.获取独占锁 
    2.如果有安全管理器，使用安全管理器检查当前线程是否有权限关闭线程池，如果没有权限则抛出SecurityException。 
    3.尝试停止所有的活动执行任务 
    4.暂停等待任务的处理 
    5.获取等待执行的任务列表 
    6.释放锁 
    7.将线程池状态设置为TERMINATED 
    8.返回等待执行的任务列表

#####   shutdown()和shutdownNow()的区别
    1   调用shutdown()后，线程池状态立刻变为SHUTDOWN，而调用shutdownNow()，线程池状态立刻变为STOP。
    2   shutdown()通过中断空闲线程、不接受新任务的方式按过去执行已提交任务的顺序发起一个有序的关闭，
        shutdownNow()无差别地停止所有的活动执行任务，暂停等待任务的处理。也就是说，shutdown()等待任务执行完才中断线程，
        而shutdownNow()不等任务执行完就中断了线程。
















