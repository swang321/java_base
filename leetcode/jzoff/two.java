import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author whh
 * @desc 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/31 17:33
 */
public class two {

    public static void main(String[] args) {

        int[] sz = {2, 3, 1, 0, 2, 5, 3};
        int repeatNumber = findRepeatNumber(sz);
        System.out.println(repeatNumber);
    }

    public static int findRepeatNumber(int[] nums) {

        HashMap<Integer, Object> num = new HashMap<>(nums.length);
        for (int i : nums) {
            boolean flag = num.containsKey(i);
            if (!flag) {
                num.put(i,null);
            } else {
                return i;
            }
        }
        return 0;
    }
}
