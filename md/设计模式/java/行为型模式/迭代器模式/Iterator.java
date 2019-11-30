package 行为型模式.迭代器模式;

/**
 * 抽象迭代器
 *
 * @Author whh
 */
interface Iterator {

    void first();

    void next();

    boolean hasNext();

    Object currentItem();

}
