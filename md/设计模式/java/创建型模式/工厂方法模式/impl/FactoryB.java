package 创建型模式.工厂方法模式.impl;

import 创建型模式.工厂方法模式.interfaces.IFactory;
import 创建型模式.工厂方法模式.interfaces.IProduct;

/**
 * @Author whh
 */
public class FactoryB implements IFactory {

    IProduct productB;

    public FactoryB() {
        this.productB = new ProductB();
    }

    @Override
    public IProduct getProduct() {
        return this.productB;
    }
}
