package 行为型模式.访问者模式;

/**
 * 抽象访问者
 *
 * @Author whh
 */
public interface Visitor {

    void visitConcreteElementA(ConcreteElementA cea);

    void visitConcreteElementA(ConcreteElementB ceb);

}
