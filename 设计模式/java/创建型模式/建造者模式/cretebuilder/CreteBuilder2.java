package 创建型模式.建造者模式.cretebuilder;

import 创建型模式.建造者模式.entity.Product;
import 创建型模式.建造者模式.interfaces.Builder;

/**
 * @Author whh
 */
public class CreteBuilder2 implements Builder {

    Product product = new Product();

    public void buildPartA() {
        product.setPartA("2a");
    }

    public void buildPartB() {
        product.setPartB("2b");
    }

    public void buildPartC() {
        product.setPartC("2c");
    }

    public Product getResult() {
        return product;
    }
}
