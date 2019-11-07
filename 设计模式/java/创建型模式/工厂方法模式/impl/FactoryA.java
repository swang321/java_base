package 创建型模式.工厂方法模式.impl;

import 创建型模式.工厂方法模式.interfaces.IFactory;
import 创建型模式.工厂方法模式.interfaces.IProduct;

/**
 * @Author whh
 */
public class FactoryA implements IFactory {

    ProductA productA;

    public FactoryA() {
        this.productA = new ProductA();
    }

    @Override
    public IProduct getProduct() {
        return this.productA;
    }
}
