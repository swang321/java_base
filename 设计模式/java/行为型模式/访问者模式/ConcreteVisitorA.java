package 行为型模式.访问者模式;

/**
 * 具体访问者
 *
 * @Author whh
 */
public class ConcreteVisitorA implements Visitor {

    @Override
    public void visitConcreteElementA(ConcreteElementA cea) {
        cea.doSomething();
    }

    @Override
    public void visitConcreteElementA(ConcreteElementB ceb) {
        ceb.doSomething();
    }
}
