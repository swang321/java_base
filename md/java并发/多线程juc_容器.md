# java_basic 

1   juc容器

#### collections
    List,Set,Map,Queue

#####   List
    CopyOnWriteArrayList 相当于线程安全得 ArrayList

#####   Set
    CopyOnWriteArraySet 相当于线程安全的    HashSet
    ConcurrentSkipListSet   相当于线程安全的    TreeSet

#####   Map
    ConcurrentHashMap   是线程安全的哈希表，相当于线程安全的  HashMap
    ConcurrentSkipListMap   是线程安全的有序的哈希表，相当于线程安全的   TreeMap

#####   Queue 
    ArrayBlockingQueue      是一个由基于数组的、线程安全的、有界阻塞队列。
    LinkedBlockingQueue     是一个基于单向链表的、可指定大小的阻塞队列。
    LinkedBlockingDeque     是一个基于单向链表的、可指定大小的双端阻塞队列。
    ConcurrentLinkedDeque   是一个基于双向链表的、无界的队列。
    ConcurrentLinkedQueue   是一个基于单向链表的、无界的队列。


#####   CopyOnWriteArrayList
CopyOnWriteArrayList底层仍是数组
写操作时使用的锁是ReentrantLock。
为了当写操作改变了底层数组array时，读操作可以得知这个消息，需要使用volatile来保证array的可见性。
读操作都是没有加锁的。写操作都加了锁。
有利就有弊，写时复制提高了读操作的性能，但写操作时内存中会同时存在资源和资源的副本，可能会占用大量的内存。

#####   ConcurrentHashMap























