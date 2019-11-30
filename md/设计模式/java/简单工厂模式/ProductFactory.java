package 简单工厂模式;

/**
 * @Author whh
 */
public class ProductFactory {


    public IProduct getProduct(String productType) {
        if ("ProductA".equalsIgnoreCase(productType)) {
            return new ProductA();
        } else if ("ProductB".equalsIgnoreCase(productType)) {
            return new ProductB();
        }
        return null;
    }

}
