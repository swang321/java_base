package 结构型模型.装饰模式;

/**
 * @Author whh
 */
public class Client {

    public static void main(String[] args) {

        Component component = new CreateComponent();
        CreateDecortor createDecortor = new CreateDecortor(component);

        component.operation();
        System.out.println("*--------------");
        createDecortor.operation();

    }
}

//      Java I/O中的FilterInputStream、FilterOutputStream、BufferedInputStream、
//      DataInputStream等类中使用了装饰模式。详情请参考 Java8 I/O源码-FilterInputStream、FilterOutputStream与装饰器模式
