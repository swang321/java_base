package 行为型模式.访问者模式;

/**
 * 抽象元素
 *
 * @Author whh
 */
public abstract class Element {

    public abstract void accept(Visitor visitor);

}
