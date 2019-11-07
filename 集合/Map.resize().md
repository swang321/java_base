# java基础
### map.resize()

扩容

    final Node<K, V>[] resize() {
        // 旧数组
        Node<K, V>[] oldTab = table;
        // 旧容量
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        // 旧扩容门槛
        int oldThr = threshold;
        int newCap, newThr = 0;
        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {
                // 如果旧容量达到了最大容量，则不再进行扩容
                threshold = Integer.MAX_VALUE;
                return oldTab;
            } else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                    oldCap >= DEFAULT_INITIAL_CAPACITY)
                // 如果旧容量的两倍小于最大容量并且旧容量大于默认初始容量（16），则容量扩大为两部，扩容门槛也扩大为两倍
                newThr = oldThr << 1; // double threshold
        } else if (oldThr > 0) // initial capacity was placed in threshold
            // 使用非默认构造方法创建的map，第一次插入元素会走到这里
            // 如果旧容量为0且旧扩容门槛大于0，则把新容量赋值为旧门槛
            newCap = oldThr;
        else {               // zero initial threshold signifies using defaults
            // 调用默认构造方法创建的map，第一次插入元素会走到这里
            // 如果旧容量旧扩容门槛都是0，说明还未初始化过，则初始化容量为默认容量，扩容门槛为默认容量*默认装载因子
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int) (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {
            // 如果新扩容门槛为0，则计算为容量*装载因子，但不能超过最大容量
            float ft = (float) newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float) MAXIMUM_CAPACITY ?
                    (int) ft : Integer.MAX_VALUE);
        }
        // 赋值扩容门槛为新门槛
        threshold = newThr;
        // 新建一个新容量的数组
        @SuppressWarnings({"rawtypes", "unchecked"})
        Node<K, V>[] newTab = (Node<K, V>[]) new Node[newCap];
        // 把桶赋值为新数组
        table = newTab;
        // 如果旧数组不为空，则搬移元素
        if (oldTab != null) {
            // 遍历旧数组
            for (int j = 0; j < oldCap; ++j) {
                Node<K, V> e;
                // 如果桶中第一个元素不为空，赋值给e
                if ((e = oldTab[j]) != null) {
                    // 清空旧桶，便于GC回收  
                    oldTab[j] = null;
                    // 如果这个桶中只有一个元素，则计算它在新桶中的位置并把它搬移到新桶中
                    // 因为每次都扩容两倍，所以这里的第一个元素搬移到新桶的时候新桶肯定还没有元素
                    if (e.next == null)
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode)
                        // 如果第一个元素是树节点，则把这颗树打散成两颗树插入到新桶中去
                        ((TreeNode<K, V>) e).split(this, newTab, j, oldCap);
                    else { // preserve order
                        // 如果这个链表不止一个元素且不是一颗树
                        // 则分化成两个链表插入到新的桶中去
                        // 比如，假如原来容量为4，3、7、11、15这四个元素都在三号桶中
                        // 现在扩容到8，则3和11还是在三号桶，7和15要搬移到七号桶中去
                        // 也就是分化成了两个链表
                        Node<K, V> loHead = null, loTail = null;
                        Node<K, V> hiHead = null, hiTail = null;
                        Node<K, V> next;
                        do {
                            next = e.next;
                            // (e.hash & oldCap) == 0的元素放在低位链表中
                            // 比如，3 & 4 == 0
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            } else {
                                // (e.hash & oldCap) != 0的元素放在高位链表中
                                // 比如，7 & 4 != 0
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        // 遍历完成分化成两个链表了
                        // 低位链表在新桶中的位置与旧桶一样（即3和11还在三号桶中）
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        // 高位链表在新桶中的位置正好是原来的位置加上旧容量（即7和15搬移到七号桶了）
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }

（1）如果使用是默认构造方法，则第一次插入元素时初始化为默认值，容量为16，扩容门槛为12；

（2）如果使用的是非默认构造方法，则第一次插入元素时初始化容量等于扩容门槛，扩容门槛在构造方法里等于传入容量向上最近的2的n次方；

（3）如果旧容量大于0，则新容量等于旧容量的2倍，但不超过最大容量2的30次方，新扩容门槛为旧扩容门槛的2倍；

（4）创建一个新容量的桶；

（5）搬移元素，原链表分化成两个链表，低位链表存储在原来桶的位置，高位链表搬移到原来桶的位置加旧容量的位置；