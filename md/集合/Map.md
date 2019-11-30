# java基础
### map HashMap、LinkedHashMap、WeakHashMap、TreeMap、ConcurrentHashMap、ConcurrentSkipListMap，另外还有两个比较古老的Map实现HashTable和Properties

(1)什么是散列表?
 
(2)怎么实现一个散列表?
 
(3)java中HashMap实现方式的演进?
 
(4)HashMap的容量有什么特点?
 
(5)HashMap是怎么进行扩容的?
 
(6)HashMap中的元素是否是有序的?
 
(7)HashMap何时进行树化?何时进行反树化?
 
(8)HashMap是怎么进行缩容的?
 
(9)HashMap插入、删除、查询元素的时间复杂度各是多少?
 
(10)HashMap中的红黑树实现部分可以用其它数据结构代替吗?

HashMap

    HashMap的实现采用了（数组 + 链表 + 红黑树）的复杂结构，数组的一个元素又称作桶。
    在添加元素时，会根据hash值算出元素在数组中的位置，如果该位置没有元素，
    则直接把元素放置在此处，如果该位置有元素了，则把元素以链表的形式放置在链表的尾部。
    当一个链表的元素个数达到一定的数量（且数组的长度达到一定的长度）后，
    则把链表转化为红黑树，从而提高效率。
    数组的查询效率为O(1)，链表的查询效率是O(k)，红黑树的查询效率是O(log k)，
    k为桶中的元素个数，所以当元素数量非常多的时候，转化为红黑树能极大地提高效率
    
    （1）HashMap是一种散列表，采用（数组 + 链表 + 红黑树）的存储结构；
    
    （2）HashMap的默认初始容量为16（1<<4），默认装载因子为0.75f，容量总是2的n次方；
    
    （3）HashMap扩容时每次容量变为原来的两倍；
    
    （4）当桶的数量小于64时不会进行树化，只会扩容；
    
    （5）当桶的数量大于64且单个桶中元素的数量大于8时，进行树化；
    
    （6）当单个桶中元素数量小于6时，进行反树化；
    
    （7）HashMap是非线程安全的容器；
    
    （8）HashMap查找添加元素的时间复杂度都为O(1)；

 
(11)LinkedHashMap是怎么实现的?
 
(12)LinkedHashMap是有序的吗?怎么个有序法?
 
(13)LinkedHashMap如何实现LRU缓存淘汰策略?
 
(14)WeakHashMap使用的数据结构?
 
(15)WeakHashMap具有什么特性?
 
(16)WeakHashMap通常用来做什么?
 
(17)WeakHashMap使用String作为key是需要注意些什么?为什么?
 
(18)什么是弱引用?
 
(19)红黑树具有哪些特性?
 
(20)TreeMap就有序的吗?怎么个有序法?
 
(21)TreeMap是否需要扩容?
 
(22)什么是左旋?什么是右旋?
 
(23)红黑树怎么插入元素?
 
(24)红黑树怎么删除元素?
 
(25)为什么要进行平衡?
 
(26)如何实现红黑树的遍历?
 
(27)TreeMap中是怎么遍历的?
 
(28)TreeMap插入、删除、查询元素的时间复杂度各是多少?
 
(29)HashMap在多线程环境中什么时候会出现问题?


 
(30)ConcurrentHashMap的存储结构?
 
(31)ConcurrentHashMap是怎么保证并发安全的?
 
(32)ConcurrentHashMap是怎么扩容的?
 
(33)ConcurrentHashMap的size()方法的实现知多少?
 
(34)ConcurrentHashMap是强一致性的吗?
 
(35)ConcurrentHashMap不能解决什么问题?
 
(36)ConcurrentHashMap中哪些地方运用到分段锁的思想?
 
(37)什么是伪共享?怎么避免伪共享?
 
(38)什么是跳表?
 
(40)ConcurrentSkipList是有序的吗?
 
(41)ConcurrentSkipList是如何保证线程安全的?
 
(42)ConcurrentSkipList插入、删除、查询元素的时间复杂度各是多少?
 
(43)ConcurrentSkipList的索引具有什么特性?
 
(44)为什么Redis选择使用跳表而不是红黑树来实现有序集合?
