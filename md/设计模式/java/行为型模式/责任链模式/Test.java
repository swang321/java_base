package 行为型模式.责任链模式;

import cn.hutool.core.util.NumberUtil;

import java.math.BigDecimal;

/**
 * @Author: whh
 * @Date: 2020/7/7 16:31
 * @Description:
 */
public class Test {
    public static void main(String[] args) {

        BigDecimal roundStart = NumberUtil.round("1000", 2);
        BigDecimal roundEnd = NumberUtil.round("200", 2);
        BigDecimal userMoney = NumberUtil.round("200", 2);

        boolean greater = NumberUtil.isGreater(roundStart, roundEnd);
        System.out.println(greater);


    }

}
