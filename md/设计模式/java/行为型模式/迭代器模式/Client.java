package 行为型模式.迭代器模式;

/**
 * @Author whh
 */
public class Client {

    public static void main(String[] args) {

        ConcreteAggregate aggregate = new ConcreteAggregate();
        ConcreteIterator iterator = aggregate.createIterator();
        iterator.first();

    }

}
