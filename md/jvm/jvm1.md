## jvm.md


####  简述内存泄漏与溢出的区别？何时产生内存泄漏？

    内存泄漏：持有不在使用对象的引用，导致jvm无法回收对象占的空间
    溢出：经过gc后，jvm仍旧无法为新对象分配足够的空间，就会产生溢出
    
#### 运行时数据区域

#### 线程共享区域

1 方法区

2 堆

#### 线程隔离区域

3 虚拟机栈

4 本地方法栈

5 程序计数器

    





