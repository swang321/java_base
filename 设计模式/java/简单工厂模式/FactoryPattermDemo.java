package 简单工厂模式;

/**
 * @Author whh
 */
public class FactoryPattermDemo {

    public static void main(String[] args) {

        ProductFactory productFactory = new ProductFactory();

        IProduct productA = productFactory.getProduct("ProductA");
        productA.get();
        IProduct productB = productFactory.getProduct("ProductB");
        productB.get();

    }
}
//  你在哪里用到了简单工厂模式？
