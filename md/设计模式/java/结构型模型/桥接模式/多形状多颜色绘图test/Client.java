package 结构型模型.桥接模式.多形状多颜色绘图test;

/**
 * @Author whh
 */
public class Client {

    public static void main(String[] args) {

        Shape shape = new Circle();
        shape.iColor = new Red();
        shape.draw(shape);

        shape = new Circle();
        shape.iColor = new Green();
        shape.draw(shape);

    }

}
//适用场景
//      系统需要使用现有的类，而类的接口不符合系统的需要。
//      想要建立一个可以重复使用的类，用于与一些彼此之间没有太大关联的一些类，包括一些可能在将来引进的类一起工作。

//适用场景
//      JDBC。JDBC给出一个客户端通用的抽象接口，每一个具体数据库引擎（如SQL Server、Oracle、MySQL等）
//      的JDBC驱动软件都是一个介于JDBC接口和数据库引擎接口之间的适配器软件。
