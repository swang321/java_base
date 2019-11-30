package 结构型模型.外观模式;

/**
 * @Author whh
 */
public class Facade {

    private SubSystemA subSystemA = new SubSystemA();
    private SubSystemB subSystemB = new SubSystemB();


    public void operationA() {
        subSystemA.operation();
    }

    public void operationB() {
        subSystemB.operation();
    }

}
