package io.test;

import java.time.LocalDate;

/**
 * @Author whh  2019/7/30 16:50
 */
public class Test2 {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate halfAYear = today.minusMonths(6).withDayOfMonth(1);
        LocalDate tempDate = halfAYear;
        while (tempDate.getYear() < today.getYear() || (tempDate.getYear() == today.getYear() && tempDate.getMonthValue() <= today.getMonthValue())) {
//            temp.addAll(statsDataMapper.statActivePlayerByDay(halfAYear.toString(), today.toString(), tempDate.format(MONTH_FORMATTER)));
            System.out.println(tempDate);
            tempDate = tempDate.plusMonths(1);
        }


    }

}
