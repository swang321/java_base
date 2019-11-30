package 结构型模型.装饰模式;

/**
 * 具体构件ConcreteComponent.java
 *
 * @Author whh
 */
public class CreateComponent extends Component {


    @Override
    void operation() {
        System.out.println("ConcreteComponent.operation()");
    }
}
