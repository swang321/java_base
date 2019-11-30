package 结构型模型.装饰模式;

/**
 * 抽象装饰类
 *
 * @Author whh
 */
public class Decorator extends Component {

    /**
     * 维持一个对抽象构件对象的引用
     */
    private Component component;

    /**
     * 注入一个抽象构件类型的对象
     */
    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    void operation() {
        // 调用原有业务方法
        component.operation();
    }
}
