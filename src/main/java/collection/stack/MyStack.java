package collection.stack;

/**
 * @Date: 2019/1/8 14:21
 * @Description: 2状态：栈空？；栈满？  2操作：压栈push；弹栈pop。
 * 基于数组得栈(this)   基于链表得栈(略)
 * @Author admin
 */
public class MyStack<T> extends StackParent {

    public MyStack() {
    }

    /**
     * 测试堆栈是否为空。
     */
    public boolean empty() {
        return size() == 0;
    }

    /**
     * 查看堆栈顶部的对象，但不从堆栈中移除它。
     */
    public Object peek() {
        int len = size();
        if (len == 0 || len > size()) {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    size());
        }
        return elementData[top - 1];
    }

    /**
     * 出栈
     */
    public Object pop() {
        Object obj;
        int len = size();
        obj = peek();
        removeElement(len - 1);
        return obj;
    }

    /**
     * 进栈
     */
    public Object push(Object obj) {
        addElement(obj);
        return obj;
    }

    /**
     * 返回对象在堆栈中的位置，最后面第一个出现得元素，以 1 为基数。
     */
    public int search(Object obj) {
        int i = lastObj(obj);
        if (i >= 0) {
            return size() - i;
        }
        //表示不存在
        return -1;
    }

}
