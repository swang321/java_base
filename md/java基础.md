# java_basic 

1   &和&&的区别
  
    Java中&&和&都是表示与的逻辑运算符，都表示逻辑运输符and，当两边的表达式都为true的时候，整个运算结果才为true，否则为false。
    
    &&的短路功能，当第一个表达式的值为false的时候，则不再计算第二个表达式；&则两个表达式都执行。
            int i = 0;
            if (i == 3 && ++i > 0) {
            }
            System.out.println("i = " + i);        输出   0
            
    &可以用作位运算符，当&两边的表达式不是Boolean类型的时候，&表示按位操作。
        int i = 0;
        if (i == 3 & ++i > 0) {
        }
        System.out.println("i = " + i);        输出   1
        
        
        
    | 和 || 的区别
    
    if(表达式a  |   表达式b)     a 为 true  时  才会计算  b
    if(表达式a  ||   表达式b)     a 为 true  时  就直接返回了  不会计算    b
    
    
2   Java平台的理解？“Java是解释执行”，这句话正确吗？

    1   书写一次，到处运行   垃圾收集
    2   Java是解释执行”这句话，这个说法不太准确
        开发的Java的源代码，首先通过Javac编译成为字节码（bytecode），然后，在运行时，
        通过 Java虚拟机（JVM）内嵌的解释器将字节码转换成为最终的机器码。但是常见的JVM，
        比如我们大多数情况使用的Oracle JDK提供的Hotspot JVM，都提供了JIT（Just-In-Time）编译器，
        也就是通常所说的动态编译器，JIT能够在运行时将热点代码编译成机器码，
        这种情况下部分热点代码就属于编译执行，而不是解释执行了。
        
3   对比Exception和Error    
    
    1   Exception和Error都是继承了Throwable类  
    2   Throwable类型的实例才可以被抛出（throw）或者捕获（catch），它是异常处理机制的基本组成类型。
    3   Exception是程序正常运行中，可以预料的意外情况，可能并且应该被捕获，进行相应处理。
    4   Error是指在正常情况下，不大可能出现的情况，绝大部分的Error都会导致程序（比如JVM自身）处于非正常的、
        不可恢复状态。既然是非正常情况，所以不便于也不需要捕获，常见的比如OutOfMemoryError之类，都是Error的子类。    
        
4   final、finally、 finalize有什么不同

    1   final可以用来修饰类、方法、变量，分别有不同的意义，final修饰的class代表不可以继承扩展，
        final的变量是不可以修改的，而final的方法也是不可以重写的（override）。        
    2   finally则是Java保证重点代码一定要被执行的一种机制。
        我们可以使用try-finally或者try-catch-finally来进行类似关闭JDBC连接、保证unlock锁等动作。    
    3   finalize是基础类java.lang.Object的一个方法，它的设计目的是保证对象在被垃圾收集前完成特定资源的回收。
        finalize机制现在已经不推荐使用，并且在JDK 9开始被标记为deprecated。   
        
5   强引用、软引用、弱引用、幻象引用有什么区别？具体使用场景是什么
    
    软引用:当系统内存足够时它不会被回收，当系统内存空间不足时它会被回收
    弱引用:只要垃圾回收机制一运行，不管 JVM 的内存空间是否足够，总会回收该对象占用的内存
    虚引用:它不能单独使用，必须和引用队列联合使用。虚引用的主要作用是跟踪对象被垃圾回收的状态。

6   String、StringBuffer、StringBuilder有什么区别？
    
    String                 final 不可变 每次拼接都会产生新的对象
    StringBuffer           每次拼接不会产生新的对象 线程安全
    StringBuilder          每次拼接不会产生新的对象 线程不安全
    
7   Java反射机制，动态代理是基于什么原理

    反射我们可以直接操作类或者对象，比如获取某个对象的类定义，获取类声明的属性和方法，
    调用方法或者构造对象，甚至可以运行时修改类定义
    
    动态代理是一种方便运行时动态构建代理、动态处理代理方法调用的机制，很多场景都是利用类似机制做到的，
    比如用来包装RPC调用、面向切面的编程（AOP）。    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    