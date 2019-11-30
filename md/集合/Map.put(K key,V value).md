# java基础
### map.put(K key, V value)

添加元素

    public V put(K key, V value) {
        // 调用hash(key)计算出key的hash值
        return putVal(hash(key), key, value, false, true);
    }
    
    static final int hash(Object key) {
        int h;
        // 如果key为null，则hash值为0，否则调用key的hashCode()方法
        // 并让高16位与整个hash异或，这样做是为了使计算出的hash更分散
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K, V>[] tab;
        Node<K, V> p;
        int n, i;
        // 如果桶的数量为0，则初始化
        if ((tab = table) == null || (n = tab.length) == 0)
            // 调用resize()初始化
            n = (tab = resize()).length;
        // (n - 1) & hash 计算元素在哪个桶中
        // 如果这个桶中还没有元素，则把这个元素放在桶中的第一个位置
        if ((p = tab[i = (n - 1) & hash]) == null)
            // 新建一个节点放在桶中
            tab[i] = newNode(hash, key, value, null);
        else {
            // 如果桶中已经有元素存在了
            Node<K, V> e;
            K k;
            // 如果桶中第一个元素的key与待插入元素的key相同，保存到e中用于后续修改value值
            if (p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)
                // 如果第一个元素是树节点，则调用树节点的putTreeVal插入元素
                e = ((TreeNode<K, V>) p).putTreeVal(this, tab, hash, key, value);
            else {
                // 遍历这个桶对应的链表，binCount用于存储链表中元素的个数
                for (int binCount = 0; ; ++binCount) {
                    // 如果链表遍历完了都没有找到相同key的元素，说明该key对应的元素不存在，则在链表最后插入一个新节点
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        // 如果插入新节点后链表长度大于8，则判断是否需要树化，因为第一个元素没有加到binCount中，所以这里-1
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    // 如果待插入的key在链表中找到了，则退出循环
                    if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            // 如果找到了对应key的元素
            if (e != null) { // existing mapping for key
                // 记录下旧值
                V oldValue = e.value;
                // 判断是否需要替换旧值
                if (!onlyIfAbsent || oldValue == null)
                    // 替换旧值为新值
                    e.value = value;
                // 在节点被访问后做点什么事，在LinkedHashMap中用到
                afterNodeAccess(e);
                // 返回旧值
                return oldValue;
            }
        }
        // 到这里了说明没有找到元素
        // 修改次数加1
        ++modCount;
        // 元素数量加1，判断是否需要扩容
        if (++size > threshold)
            // 扩容
            resize();
        // 在节点插入后做点什么事，在LinkedHashMap中用到
        afterNodeInsertion(evict);
        // 没找到元素返回null
        return null;
    }

（1）计算key的hash值；

（2）如果桶（数组）数量为0，则初始化桶；

（3）如果key所在的桶没有元素，则直接插入；

（4）如果key所在的桶中的第一个元素的key与待插入的key相同，说明找到了元素，转后续流程（9）处理；

（5）如果第一个元素是树节点，则调用树节点的putTreeVal()寻找元素或插入树节点；

（6）如果不是以上三种情况，则遍历桶对应的链表查找key是否存在于链表中；

（7）如果找到了对应key的元素，则转后续流程（9）处理；

（8）如果没找到对应key的元素，则在链表最后插入一个新节点并判断是否需要树化；

（9）如果找到了对应key的元素，则判断是否需要替换旧值，并直接返回旧值；

（10）如果插入了元素，则数量加1并判断是否需要扩容；