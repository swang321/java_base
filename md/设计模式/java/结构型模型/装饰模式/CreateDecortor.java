package 结构型模型.装饰模式;

/**
 * 具体装饰类
 *
 * @Author whh
 */
public class CreateDecortor extends Decorator {

    /**
     * 注入一个抽象构件类型的对象
     */
    public CreateDecortor(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        // 调用原有业务方法
        super.operation();
        // 调用新增业务方法
        addedBehavior();
    }

    /**
     * 新增业务方法
     */
    private void addedBehavior() {
        System.out.println("ConcreteDecorator.addedBehavior()");
    }

}
