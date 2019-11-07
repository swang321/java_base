package java_some.inner_class;

/**
 * 成员内部类
 *
 * @Author whh  2019/8/5 14:26
 */
public class ClassOne {

    private double radius = 0;

    public ClassOne(double radius) {
        this.radius = radius;
    }

    class Draw {
        public void drawShape() {
            System.out.println("drawShape");
            System.out.println(radius);
        }
    }

    public static void main(String[] args) {
        ClassOne classOne = new ClassOne(456.0);

        Thread thread = new Thread();

    }

}
