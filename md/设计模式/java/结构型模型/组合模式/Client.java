package 结构型模型.组合模式;

/**
 * @Author whh
 */
public class Client {

    public static void main(String[] args) {
        Component leaf = new Leaf();
        leaf.add(leaf);
        leaf.operation();

        Component composite = new Composite();
        composite.add(leaf);
        composite.operation();
    }

}

//使用场景
//      XML解析
//      文件系统设计