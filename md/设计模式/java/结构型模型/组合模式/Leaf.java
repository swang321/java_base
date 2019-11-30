package 结构型模型.组合模式;

/**
 * @Author whh
 */
public class Leaf extends Component {


    @Override
    public void add(Component component) {
        // 异常处理或错误提示
        System.out.println("error 叶子节点不存在此操作");
    }

    @Override
    public void remove(Component component) {
        // 异常处理或错误提示
        System.out.println("error 叶子节点不存在此操作");
    }

    @Override
    public Component getChild(int i) {
        // 异常处理或错误提示
        System.out.println("error 叶子节点不存在此操作");
        return null;
    }

    @Override
    public void operation() {
        System.out.println("Leaf.operation()");
    }
}
