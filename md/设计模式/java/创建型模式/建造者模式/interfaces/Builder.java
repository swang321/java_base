package 创建型模式.建造者模式.interfaces;

import 创建型模式.建造者模式.entity.Product;

/**
 * @Author whh
 */
public interface Builder {

    void buildPartA();

    void buildPartB();

    void buildPartC();

    Product getResult();

}
