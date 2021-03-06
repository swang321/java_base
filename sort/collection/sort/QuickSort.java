package collection.sort;

import java.util.Arrays;

/**
 * @Description: 无重复数字时得    快速排序   快排
 * @Author admin
 */
public class QuickSort {

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
    private static int[] sort(int[] array, int left, int right) {
        int key = array[left];
        if (left < right) {
            while (left < right) {
                while (left < right && array[right] >= key) {
                    right--;
                }
                if (left < right) {
                    array[left] = array[right];
                    left++;
                }
                while (left < right && array[left] <= key) {
                    left++;
                }
                if (left < right) {
                    array[right] = array[left];
                    right--;
                }
            }
            array[left] = key;
            System.out.println(left);
            System.out.println(right);
            sort(array, left, left - 1);
            sort(array, left + 1, right);
        }
        return array;
    }

}
