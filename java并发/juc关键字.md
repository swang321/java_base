####  juc关键字 synchronized ThreadLocal  volatile

## synchronized

    可以保证方法或者代码块在运行时，同一时刻只有一个方法可以进入到临界区，同时它还可以保证共享变量的内存可见性

#### Java对象头和monitor


#### jdk1.6 优化 synchronized 

自旋锁 

    线程的阻塞和唤醒需要CPU从用户态转为核心态 自旋锁就是让该线程A等待一段时间，不会被立即挂起，
    看持有锁的线程B是否会很快释放锁。怎么等待呢？线程A执行一段无意义的循环即可（自旋） 
    如果自旋超过了定义的时间仍然没有获取到锁，则线程A应该被挂起

适应自旋锁

    意味着自旋的次数不再是固定的，它是由前一次在同一个锁上的自旋时间及锁的拥有者的状态来决定

锁消除

锁粗化

轻量级锁

偏向锁

##### Java中每一个对象都可以作为锁，这是synchronized实现同步的基础：

    1 普通同步方法，锁是当前实例对象
    2 静态同步方法，锁是当前类的class对象
    3 同步方法块，锁是括号里面的对象


synchronized 作用
    
    1   确保线程互斥访问同步代码
    2   保证共享变量的修改能够及时可见
    3   有效解决重排序的问题
    
synchronized 通过 monitor 和 monitorexit 对象 （指令）来控制访问同步

## ThreadLocal 

    1   ThreadLocal的内部类ThreadLocalMap（weakreference 虚引用） 维护线程中的变量
    2   ThreadLocal会为每一个线程提供一个独立的变量副本，从而隔离了多个线程对数据的访问冲突
    
## volatile （volatile能够保证可见性和防止指令重排）
    
    1   被volatile关键字修饰的变量，其他线程如果需要重写读取该变量会再次从主内存中读取，
        而不是读取自己的高速缓存中的。
    2   被volatile关键字修饰变量不会指令重排序。
    3   volatile不能保证原子性

#### volatile 
    
    1保证可见性、不保证原子性
    
    2禁止指令重排序
    
    DCL（双重检查锁)  double check lock
    
         public class Singleton {
               //通过volatile关键字来确保安全
               private volatile static Singleton singleton;
            
               private Singleton(){}
            
               public static Singleton getInstance(){
                   if(singleton == null){
                       synchronized (Singleton.class){
                           if(singleton == null){
                               singleton = new Singleton();
                           }
                       }
                   }
                   return singleton;
               }
            }


