package 结构型模型.组合模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author whh
 */
public class Composite extends Component {

    private List<Component> list = new ArrayList<Component>();

    @Override
    public void add(Component component) {
        list.add(component);
    }

    @Override
    public void remove(Component component) {
        list.remove(component);
    }

    @Override
    public Component getChild(int i) {
        return list.get(i);
    }

    @Override
    public void operation() {
        // 容器构件具体业务方法的实现
        // 递归调用成员构件的业务方法
        for (Object obj : list) {
            ((Component) obj).operation();
        }
    }
}
