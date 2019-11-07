package 创建型模式.工厂方法模式.impl;

import 创建型模式.工厂方法模式.interfaces.IProduct;

/**
 * @Author whh
 */
public class ProductA implements IProduct {
    @Override
    public void getProduct() {
        System.out.println("productA");
    }
}
