package 结构型模型.桥接模式.桥接;

/**
 * @Author whh
 */
public class RefinedAbstraction extends Abstraction {

    @Override
    public void operation() {
        implementor.operationImpl();
    }

}
