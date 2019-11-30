package 创建型模式.原型模式;

/**
 * @Author whh
 */
public class CreatePrototype implements Prototype, Cloneable {

    @Override
    public Prototype clone() {
        CreatePrototype prototype = null;
        try {
            prototype = (CreatePrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return prototype;
    }

    public void show() {
        System.out.println("CreatePrototype:{}" + this.toString());
    }
}
