package 行为型模式.访问者模式;

/**
 * 具体元素
 *
 * @Author whh
 */
public class ConcreteElementB extends Element {


    public void doSomething() {
        System.out.println("这是元素B");
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementA(this);
    }
}
