package collection.search;

import java.util.Arrays;

/**
 * @Date: 2019/1/10 17:40
 * @Description:
 * @Author admin
 */
public class TestMain {

    public static void main(String[] args) {
        int[] arr = {66, 13, 51, 76, 81, 26, 57, 69, 23};
        int left = 0;
        int right = arr.length - 1;

        System.out.println(Arrays.toString(sort(arr, left, right)));

    }

    /**
     * 从右向左找第一个小于x的数
     * 从左向右找第一个大于x的数
     */
    static int[] sort(int[] array, int left, int right) {
        if (left < right) {
            int key = array[left];
            while (left < right) {
                while (array[right] < key) {
                    array[left] = array[right];
                    array[right] = key;
                    left++;
                }
                while (array[left] > key) {
                    array[right] = array[left];
                    array[left] = key;
                    right--;
                }
                if (array[left] < key) {
                    left++;
                }
                if (array[right] > key) {
                    right--;
                }
            }
        }
        return array;
    }
}
