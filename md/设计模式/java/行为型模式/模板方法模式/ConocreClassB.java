package 行为型模式.模板方法模式;

/**
 * @Author whh
 */
public class ConocreClassB extends AbstractClass {


    @Override
    public void primitiveOperation2() {
        System.out.println("步驟2：ConcreteClassB.primitiveOperation2()");
    }

    @Override
    public void primitiveOperation3() {
        System.out.println("步驟3：ConcreteClassB.primitiveOperation3()");
    }
}
