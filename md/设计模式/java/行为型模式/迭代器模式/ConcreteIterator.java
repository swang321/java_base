package 行为型模式.迭代器模式;

/**
 * 具体迭代器
 *
 * @Author whh
 */
public class ConcreteIterator implements Iterator {
    /**
     * 维持一个对具体聚合对象的引用，以便于访问存储在聚合对象中的数据
     */
    private ConcreteAggregate aggregate;

    /**
     * 定义一个游标，用于记录当前访问位置
     */
    private int cursor;

    public ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
    }

    /**
     * 根据实际情况实现方法
     */
    public void first() {

    }

    public void next() {

    }

    public boolean hasNext() {
        return false;
    }

    public Object currentItem() {
        return null;
    }





}
