package 结构型模型.桥接模式.多形状多颜色绘图test;

/**
 * @Author whh
 */
public abstract class Shape {

    IColor iColor;

    public void draw(Shape shape) {
        iColor.fillColor(shape);
    }

}
