package 行为型模式.迭代器模式;


/**
 * 抽象聚合类
 *
 * @Author whh
 */
public interface Aggregate {

    Iterator createIterator();

}
