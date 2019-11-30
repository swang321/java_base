package 创建型模式.抽象工厂模式.interfaces;

/**
 * @Author whh
 */
public interface Factory {

    /**
     * 生产 产品 A
     */
    IProductA getProductA();

    /**
     * 生产 产品 B
     */
    IProductB getProductB();

}
