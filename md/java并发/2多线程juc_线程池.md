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
RUNNING、SHUTDOWN、STOP、TIDYING、TERMINATED 五种状态

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


线程池的执行流程
    
    任务被提交到线程池，会先判断当前线程数量是否小于corePoolSize，如果小于则创建线程来执行提交的任务，否则将任务放入workQueue队列，
    如果workQueue满了，则判断当前线程数量是否小于maximumPoolSize,如果小于则创建线程执行任务，否则就会调用handler，
    以表示线程池拒绝接收任务。






#### ThreadPoolExecutor执行execute方法分下面4种情况。

1）如果当前运行的线程少于corePoolSize，则创建新线程来执行任务（注意，执行这一步骤
需要获取全局锁）。

2）如果运行的线程等于或多于corePoolSize，则将任务加入BlockingQueue。

3）如果无法将任务加入BlockingQueue（队列已满），则创建新的线程来处理任务（注意，执
行这一步骤需要获取全局锁）。

4）如果创建新线程将使当前运行的线程超出maximumPoolSize，任务将被拒绝，并调用
RejectedExecutionHandler.rejectedExecution()方法。

#### 创建线程池核心参数

new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
milliseconds,runnableTaskQueue, handler);

1）corePoolSize（线程池的基本大小）：当提交一个任务到线程池时，线程池会创建一个线
程来执行任务，即使其他空闲的基本线程能够执行新任务也会创建线程，等到需要执行的任
务数大于线程池基本大小时就不再创建。如果调用了线程池的prestartAllCoreThreads()方法，
线程池会提前创建并启动所有基本线程。

2）runnableTaskQueue（任务队列）：用于保存等待执行的任务的阻塞队列。可以选择以下几
个阻塞队列。
·ArrayBlockingQueue：是一个基于数组结构的有界阻塞队列，此队列按FIFO（先进先出）原
则对元素进行排序。
·LinkedBlockingQueue：一个基于链表结构的阻塞队列，此队列按FIFO排序元素，吞吐量通
常要高于ArrayBlockingQueue。静态工厂方法Executors.newFixedThreadPool()使用了这个队列。
·SynchronousQueue：一个不存储元素的阻塞队列。每个插入操作必须等到另一个线程调用
移除操作，否则插入操作一直处于阻塞状态，吞吐量通常要高于Linked-BlockingQueue，静态工
厂方法Executors.newCachedThreadPool使用了这个队列。
·PriorityBlockingQueue：一个具有优先级的无限阻塞队列。

3）maximumPoolSize（线程池最大数量）：线程池允许创建的最大线程数。如果队列满了，并
且已创建的线程数小于最大线程数，则线程池会再创建新的线程执行任务。值得注意的是，如
果使用了无界的任务队列这个参数就没什么效果。
4）ThreadFactory：用于设置创建线程的工厂，可以通过线程工厂给每个创建出来的线程设
置更有意义的名字。使用开源框架guava提供的ThreadFactoryBuilder可以快速给线程池里的线
程设置有意义的名字，代码如下。
new ThreadFactoryBuilder().setNameFormat("XX-task-%d").build();

5）RejectedExecutionHandler（饱和策略）：当队列和线程池都满了，说明线程池处于饱和状
态，那么必须采取一种策略处理提交的新任务。这个策略默认情况下是AbortPolicy，表示无法
处理新任务时抛出异常。在JDK 1.5中Java线程池框架提供了以下4种策略。
·AbortPolicy：直接抛出异常。
·CallerRunsPolicy：只用调用者所在线程来运行任务。
·DiscardOldestPolicy：丢弃队列里最近的一个任务，并执行当前任务。
·DiscardPolicy：不处理，丢弃掉。
当然，也可以根据应用场景需要来实现RejectedExecutionHandler接口自定义策略。如记录
日志或持久化存储不能处理的任务。
·keepAliveTime（线程活动保持时间）：线程池的工作线程空闲后，保持存活的时间。所以，
如果任务很多，并且每个任务执行的时间比较短，可以调大时间，提高线程的利用率。
·TimeUnit（线程活动保持时间的单位）：可选的单位有天（DAYS）、小时（HOURS）、分钟
（MINUTES）、毫秒（MILLISECONDS）、微秒（MICROSECONDS，千分之一毫秒）和纳秒
（NANOSECONDS，千分之一微秒）。


#### 绍Executor框架的主要成员：
    ThreadPoolExecutor、ScheduledThreadPoolExecutor、
    Future接口、Runnable接口、Callable接口和Executors。

#### ThreadPoolExecutor 和 ScheduledThreadPoolExecutor

    Executors可以创建3种类型的 ThreadPoolExecutor：
    SingleThreadExecutor、FixedThreadPool和CachedThreadPool。
    
    Executors可以创建2种类型的 ScheduledThreadPoolExecutor，如下。
    ·ScheduledThreadPoolExecutor。包含若干个线程的ScheduledThreadPoolExecutor。
    ·SingleThreadScheduledExecutor。只包含一个线程的ScheduledThreadPoolExecutor。







