# java基础
### 集合 List LinkedList CopyOnWriteArrayList


1   ArrayList和LinkedList有什么区别?

2   ArrayList是怎么扩容的?

    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        // 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        // 如果新容量发现比需要的容量还小，则以需要的容量为准
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        // 如果新容量已经超过最大容量了，则使用最大容量
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // 以新容量拷贝出来一个新数组
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    （1）检查是否需要扩容；
    
    （2）如果elementData等于DEFAULTCAPACITY_EMPTY_ELEMENTDATA则初始化容量大小为DEFAULT_CAPACITY；
    
    （3）新容量是老容量的1.5倍（oldCapacity + (oldCapacity >> 1)），如果加了这么多容量发现比需要的容量还小，则以需要的容量为准；
    
    （4）创建新容量的数组并把老数组拷贝到新数组
 
3   ArrayList插入、删除、查询元素的时间复杂度各是多少?
 
4   怎么求两个集合的并集、交集、差集?
 
5   ArrayList是怎么实现序列化和反序列化的?

    通过重写writeObject 和 readObject方法的方式把其中的元素保留下来
    ArrayList实际上是动态数组，每次在放满以后自动增长设定的长度值，如果数组自动增长长度设为100，
    而实际只放了一个元素，那就会序列化99个null元素，那么为了防止一个包含大量空对象的数组被序列化，
    为了优化存储，所以，ArrayList使用transient来声明存放对象的数组elementData[]

 
6   集合的方法toArray()有什么问题?

两个方法简单总结：

    1.toArray()方法无需传入参数，可以直接将集合转换成Object数组进行返回，而且也只能返回Object类型
    
    2.toArray(T[] a)方法需要传入一个数组作为参数，并通过泛型T的方式定义参数，
        所返回的数组类型就是调用集合的泛型，所以自己无需再转型，但是根据传入数组的长度    
        与集合的实际长度的关系，会有不同的处理；
    
        a：数组长度不小于集合长度，直接拷贝，不会产生新的数组对象；
    
        b：数组长度小于集合长度，会创建一个与集合长度相同的新数组，
            将集合的数据拷贝到新数组并将新数组的引用返回。


### 总结

    （1）ArrayList内部使用数组存储元素，当数组长度不够时进行扩容，每次加一半的空间，ArrayList不会进行缩容；
    （2）ArrayList支持随机访问，通过索引访问元素极快，时间复杂度为O(1)；
    （3）ArrayList添加元素到尾部极快，平均时间复杂度为O(1)；
    （4）ArrayList添加元素到中间比较慢，因为要搬移元素，平均时间复杂度为O(n)；
    （5）ArrayList从尾部删除元素极快，时间复杂度为O(1)；
    （6）ArrayList从中间删除元素比较慢，因为要搬移元素，平均时间复杂度为O(n)；
    （7）ArrayList支持求并集，调用addAll(Collection<? extends E> c)方法即可；
    （8）ArrayList支持求交集，调用retainAll(Collection<? extends E> c)方法即可；
    （7）ArrayList支持求单向差集，调用removeAll(Collection<? extends E> c)方法即可；

7   什么是fail-fast?

    什么是 fail-fast 机制?
    
    fail-fast机制在遍历一个集合时，当集合结构被修改，会抛出Concurrent Modification Exception。
    fail-fast会在以下两种情况下抛出ConcurrentModificationException
    
    （1）单线程环境
    集合被创建后，在遍历它的过程中修改了结构。
    注意 remove()方法会让expectModcount和modcount 相等，所以是不会抛出这个异常。
    
    （2）多线程环境
    当一个线程在遍历这个集合，而另一个线程对这个集合的结构进行了修改
 
8   LinkedList是单链表还是双链表实现的?
 
9   LinkedList除了作为List还有什么用处?

    LinkedList是一个以双向链表实现的List，它除了作为List使用，还可以作为队列或者栈来使用
 
10  LinkedList插入、删除、查询元素的时间复杂度各是多少?

    （1）LinkedList是一个以双链表实现的List；
    （2）LinkedList还是一个双端队列，具有队列、双端队列、栈的特性；
    （3）LinkedList在队列首尾添加、删除元素非常高效，时间复杂度为O(1)；
    （4）LinkedList在中间添加、删除元素比较低效，时间复杂度为O(n)；
    （5）LinkedList不支持随机访问，所以访问非队列首尾的元素比较低效；
    （6）LinkedList在功能上等于ArrayList + ArrayDeque；
 
11  什么是随机访问?

    Random Access
 
12  哪些集合支持随机访问?他们都有哪些共性?

    Random Access   一步直接得到该数据的首地址
 
13  CopyOnWriteArrayList是怎么保证并发安全的?
 
14  CopyOnWriteArrayList的实现采用了什么思想?
 
15  CopyOnWriteArrayList是不是强一致性的?
 
16  CopyOnWriteArrayList适用于什么样的场景?
 
17  CopyOnWriteArrayList插入、删除、查询元素的时间复杂度各是多少?
 
18  CopyOnWriteArrayList 为什么没有size属性?

    （1）CopyOnWriteArrayList使用ReentrantLock重入锁加锁，保证线程安全；
    
    （2）CopyOnWriteArrayList的写操作都要先拷贝一份新数组，在新数组中做修改，修改完了再用新数组替换老数组，所以空间复杂度是O(n)，性能比较低下；
    
    （3）CopyOnWriteArrayList的读操作支持随机访问，时间复杂度为O(1)；
    
    （4）CopyOnWriteArrayList采用读写分离的思想，读操作不加锁，写操作加锁，且写操作占用较大内存空间，所以适用于读多写少的场合；
    
    （5）CopyOnWriteArrayList只保证最终一致性，不保证实时一致性

CopyOnWriteArrayList添加方法


    public boolean add(E e) {
        final ReentrantLock lock = this.lock;
        // 加锁
        lock.lock();
        try {
            // 获取旧数组
            Object[] elements = getArray();
            int len = elements.length;
            // 将旧数组元素拷贝到新数组中
            // 新数组大小是旧数组大小加1
            Object[] newElements = Arrays.copyOf(elements, len + 1);
            // 将元素放在最后一位
            newElements[len] = e;
            setArray(newElements);
            return true;
        } finally {
            // 释放锁
            lock.unlock();
        }
    }

    （1）加锁；
    （2）获取元素数组；
    （3）新建一个数组，大小为原数组长度加1，并把原数组元素拷贝到新数组；
    （4）把新添加的元素放到新数组的末尾；
    （5）把新数组赋值给当前对象的array属性，覆盖原数组；
    （6）解锁；

