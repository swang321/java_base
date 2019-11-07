package 结构型模型.桥接模式.多形状多颜色绘图test;

/**
 * @Author whh
 */
public class Red implements IColor {

    public void fillColor(Shape shape) {
        System.out.println("draw red" + shape.getClass().getSimpleName());
    }

}
