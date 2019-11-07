package 结构型模型.外观模式;

/**
 * @Author whh
 */
public class Client {


    public static void main(String[] args) {

        Facade facade = new Facade();
        facade.operationA();
        facade.operationB();
    }

}
