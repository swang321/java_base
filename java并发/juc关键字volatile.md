####  juc关键字  volatile

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


