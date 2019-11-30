package 行为型模式.访问者模式;

/**
 * 具体元素
 *
 * @Author whh
 */
public class ConcreteElementA extends Element {

    public void doSomething() {
        System.out.println("这是元素A");
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementA(this);
    }
}
