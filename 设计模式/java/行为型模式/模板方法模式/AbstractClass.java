package 行为型模式.模板方法模式;

/**
 * 由于模板方法是具体方法，因此模板方法模式中的抽象层只能是抽象类，而不是接口
 *
 * @Author whh
 */
public abstract class AbstractClass {

    /**
     * 把基本操作方法组合在一起形成一个总算法的方法。可以调用抽象类中基本方法，
     * 在抽象类的子类中实现的基本方法，还可以调用其他对象中的方法
     */
    public void templateMethod() {

        primitiveOperation1();
        primitiveOperation2();
        primitiveOperation3();

    }

    /**
     * 抽象类中基本方法
     */
    private void primitiveOperation1() {
        System.out.println("步驟1：AbstractClass.primitiveOperation1()");
    }

    /**
     * 抽象类中抽象基本方法，由子类去实现
     */
    public abstract void primitiveOperation2();

    /**
     * 空方法，子类中通过选择是否通过覆盖此方法来控制某些操作是否执行
     */
    public void primitiveOperation3() {

    }


}
