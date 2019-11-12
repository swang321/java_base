package collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Author whh
 */
public class MapMain {

    public static void main(String[] args) {


        MyMap myMap = new MyHashMap();


        Map map = new HashMap(16);

        TreeMap treeMap = new TreeMap();


        String ss = "132";


        System.out.println(ss.hashCode());

        ExecutorService service = Executors.newSingleThreadExecutor();
        ExecutorService service1 = Executors.newFixedThreadPool(5);
        ExecutorService service2 = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);


    }

}

//get方法总结
//
//从源码中可以看到，get(E e)可以分为三个步骤：

//        通过hash(Object key)方法计算key的哈希值hash。
//        通过getNode( int hash, Object key)方法获取node。
//        如果node为null，返回null，否则返回node.value。


//hash方法又可分为三步：
//
//        取key的hashCode第二步
//        key的hashCode高16位异或低16位
//        将第一步和第二部得到的结果进行取模运算。


//getNode方法又可分为以下几个步骤：
//
//        如果哈希表为空，或key对应的桶为空，返回null
//        如果桶中的第一个节点就和指定参数hash和key匹配上了，返回这个节点。
//        如果桶中的第一个节点没有匹配上，而且有后续节点
//        如果当前的桶采用红黑树，则调用红黑树的get方法去获取节点
//        如果当前的桶不采用红黑树，即桶中节点结构为链式结构，遍历链表，直到key匹配
//        找到节点返回null，否则返回null。


//putVal方法可以分为下面的几个步骤：
//
//        如果哈希表为空，调用resize()创建一个哈希表。
//        如果指定参数hash在表中没有对应的桶，即为没有碰撞，直接将键值对插入到哈希表中即可。
//        如果有碰撞，遍历桶，找到key映射的节点
//        桶中的第一个节点就匹配了，将桶中的第一个节点记录起来。
//        如果桶中的第一个节点没有匹配，且桶中结构为红黑树，则调用红黑树对应的方法插入键值对。
//        如果不是红黑树，那么就肯定是链表。遍历链表，如果找到了key映射的节点，就记录这个节点，退出循环。如果没有找到，在链表尾部插入节点。插入后，如果链的长度大于TREEIFY_THRESHOLD这个临界值，则使用treeifyBin方法把链表转为红黑树。
//        如果找到了key映射的节点，且节点不为null
//        记录节点的vlaue。
//        如果参数onlyIfAbsent为false，或者oldValue为null，替换value，否则不替换。
//        返回记录下来的节点的value。
//        如果没有找到key映射的节点（2、3步中讲了，这种情况会插入到hashMap中），插入节点后size会加1，这时要检查size是否大于临界值threshold，如果大于会使用resize方法进行扩容。


//可以将resize的步骤总结为
//
//        计算扩容后的容量，临界值。
//        将hashMap的临界值修改为扩容后的临界值
//        根据扩容后的容量新建数组，然后将hashMap的table的引用指向新数组。
//        将旧数组的元素复制到table中。



//  新建数组保存旧数组的
//  保存当前阈值
//  判断扩容需要的容量是否 合法
//  合法 就设置 新阈值
//  创建新table初始化容量，遍历每个桶，重新计算位置




















