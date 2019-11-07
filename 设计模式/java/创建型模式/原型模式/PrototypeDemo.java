package 创建型模式.原型模式;

/**
 * @Author whh
 */
public class PrototypeDemo {

    public static void main(String[] args) {

        CreatePrototype cp = new CreatePrototype();
        for (int i = 0; i < 5; i++) {
            CreatePrototype prototype = (CreatePrototype) cp.clone();
            prototype.show();
        }
    }
}
//优点
//      性能高。使用原型模式克隆对象比直接new一个对象性能高。
//
//缺点
//      原型模式和单例模式是冲突的。