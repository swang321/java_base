package 行为型模式.迭代器模式;


/**
 * 具体聚合类
 *
 * @Author whh
 */
public class ConcreteAggregate implements Aggregate {

    public ConcreteIterator createIterator() {
        return new ConcreteIterator(this);
    }

}
