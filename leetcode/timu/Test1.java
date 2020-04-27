import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author whh  2019/12/20 15:53
 */
public class Test1 {

//    给定 nums = [2, 7, 11, 15], target = 9
//
//    因为 nums[0] + nums[1] = 2 + 7 = 9
//    所以返回 [0, 1]

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        int[] test = test(nums, target);
        System.out.println(Arrays.toString(test));
    }

    private static int[] test(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if (map.containsKey(j)) {
                System.out.println(map.get(j));
                System.out.println(i);
                return new int[]{map.get(j), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

}
