package stack;

import java.util.Arrays;

/**
 * @Date: 2019/1/8 14:57
 * @Description:
 * @Author admin
 */
class StackParent {

    Object[] elementData;

    private int elementCount;
    /**
     * 栈顶指针
     */
    protected int top;
    /**
     * 每次扩容增加一倍
     */
    private int capacityIncrement;

    private int modCount;

    private static final int INITSIZE = 10;

    StackParent() {
        this(INITSIZE, 0);
    }

    private StackParent(int initCapacity, int capacityIncrement) {
        if (initCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initCapacity);
        }
        this.elementData = new Object[initCapacity];
        this.capacityIncrement = capacityIncrement;
    }

    int size() {
        return elementCount;
    }

    int lastObj(Object obj) {
        return lastObj(obj, elementCount - 1);
    }

    private int lastObj(Object obj, int index) {
        if (index >= elementCount || index < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    index);
        }
        
        for (int i = index; i >= 0; i--) {
            if (elementData[i] == obj) {
                return i;
            }
        }
        return -1;
    }


    void removeElement(int index) {
        modCount++;

        if (index >= elementCount || index < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    index);
        }
        int i = elementCount - index - 1;
        if (i > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, i);
        }
        elementCount--;
        top--;
        /* to let gc do its work */
        elementData[elementCount] = null;
    }

    void addElement(Object obj) {
        modCount++;
        // 判断 扩容
        ensureIncrease(elementCount + 1);
        elementData[elementCount++] = obj;
        top++;
    }

    private void ensureIncrease(int minCapacity) {
        if (minCapacity - elementData.length > 0) {
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {

        int oldSize = elementData.length;
        //   源码:     int newCapacity = oldCapacity + ((capacityIncrement > 0) ? capacityIncrement : oldCapacity);
        //  实际也是扩大了一倍
        int newSize = oldSize * 2;

        if (newSize - minCapacity < 0) {
            newSize = minCapacity;
        }
        elementData = Arrays.copyOf(elementData, newSize);
    }

    @Override
    public String toString() {
        if (elementData.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < elementCount; i++) {
            sb.append(elementData[i]);
            if (i != elementCount - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
