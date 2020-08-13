package collection.arraylist;

import collection.myexception.MyException;

import java.util.Arrays;

/**
 * @Author admin
 */
public class MyArrAyList implements IMyArrayList {

    private static final int INITSIZE = 10;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private Object[] elementData;

    private int size;

    private transient int modCount = 0;

    public MyArrAyList() {
        elementData = EMPTY_ELEMENTDATA;
    }

    public MyArrAyList(int initialCapacity) {
        if (initialCapacity > 0) {
            elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Object obj) {
        checkAndIncrease();
        elementData[size++] = obj;
    }

    private void checkAndIncrease() {
        int minCapacity = increaseCapacity(elementData, size + 1);
        ensureIncrease(minCapacity);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return elementData[index];
    }

    @Override
    public void add(int index, Object obj) {
        //检查  是否超出 elementData.length()
        checkIndex(index);
        checkAndIncrease();
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = obj;
        size++;
    }

    private void checkIndex(int index) {
        if (index > size || index < 0) {
            try {
                throw new MyException("超出范围", index);
            } catch (MyException e) {
                e.printStackTrace();
            }
        }
    }

    private static int increaseCapacity(Object[] elementData, int minCapacity) {
        if (elementData == EMPTY_ELEMENTDATA) {
            return Math.max(INITSIZE, minCapacity);
        }
        return minCapacity;
    }

    private void ensureIncrease(int minCapacity) {
        if (minCapacity - elementData.length > 0) {
            // 需要修改数字容量
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        //  记录修改次数
        modCount++;
        int oldCapacity = elementData.length;
        int newCapacity = minCapacity + (minCapacity >> 1);
        if (newCapacity - oldCapacity < 0) {
            newCapacity = oldCapacity;
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }


    @Override
    public String toString() {
        if (elementData.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i]);
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
