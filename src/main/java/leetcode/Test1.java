package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Date: 2019/1/31 15:59
 * @Description:
 * @Author admin
 */
public class Test1 {

    public static void main(String[] args) {

        int nums[] = {6, 7, 11, 2};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums, target)));

    }


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(16);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
