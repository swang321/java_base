
### array list 源码分析(jdk1.8)

#### ArrayList 是一个可以动态扩容的数组，底层事数组实现

### 属性
     // 默认初始化容量
     private static final int DEFAULT_CAPACITY = 10;
     //初始化数组
     private static final Object[] EMPTY_ELEMENTDATA = {};
     //默认初始容量下的空数组
     private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
     //lsit 保存数据的数组
     transient Object[] elementData; // non-private to simplify nested class access
     // list容量大小
     private int size;
     
### ArrayList 中的方法
    public boolean add(E e) 
    1   判断数组是否为空 如果是 则比较默认容量与实际容量 取最大值
    2   判断是否需要扩容，如果所需实际大于数组容量，扩容(动态扩容)
    3   保存数据 size++
  源码: 
    
    
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);  // Increments modCount!!
                            elementData[size++] = e;
                            return true;
    }
    
    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }
    
    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        // 如果 elementData等于空数组 则返回容量最大值
        // DEFAULT_CAPACITY是默认容量 10     minCapacity是 size+1
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }
    
    private void ensureExplicitCapacity(int minCapacity) {
        // 修改次数 加一次
        modCount++;
        
        // overflow-conscious code
        // 如果实际容量大于数组容量则扩容
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }
            
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
                
    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
    }