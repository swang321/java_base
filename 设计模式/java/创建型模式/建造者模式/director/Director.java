package 创建型模式.建造者模式.director;

import 创建型模式.建造者模式.entity.Product;
import 创建型模式.建造者模式.interfaces.Builder;

/**
 * @Author whh
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}
