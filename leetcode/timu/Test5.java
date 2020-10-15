package timu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: whh
 * @Date: 2020/10/15 15:32
 * @Description: 拥有最多糖果的孩子
 */
public class Test5 {
    public static void main(String[] args) {

        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        List<Boolean> booleans = kidsWithCandies(candies, extraCandies);
        System.out.println(booleans);
    }
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> flags = new ArrayList<>();
        int max = getMax(candies);
        for (int candy : candies) {
            flags.add(candy + extraCandies >= max);
        }
        return flags;
    }

    private static int getMax(int[] candies) {
        int max = 0;
        for (int candy : candies) {
            if (candy >= max) {
                max = candy;
            }
        }
        return max;
    }

}
