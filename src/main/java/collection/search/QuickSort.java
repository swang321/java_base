package collection.search;

import java.util.Arrays;

/**
 * @Date: 2019/1/10 15:20
 * @Description:
 * @Author admin
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {66, 13, 51, 76, 81, 26, 57, 69, 23};
        int left = 0;
        int right = arr.length - 1;

        System.out.println(Arrays.toString(quickSort(arr, left, right)));
    }

    private static int[] quickSort(int[] a, int l, int r) {
        if (l < r) {
            int i, j, x;
            i = l;
            j = r;
            x = a[i];
            while (i < j) {
                while (i < j && a[j] > x) {
                    j--; // 从右向左找第一个小于x的数
                }
                if (i < j) {
                    a[i++] = a[j];
                }
                while (i < j && a[i] < x) {
                    i++; // 从左向右找第一个大于x的数
                }
                if (i < j) {
                    a[j--] = a[i];
                }
            }
            a[i] = x;
            /* 递归调用 */
            quickSort(a, l, i - 1);
            /* 递归调用 */
            quickSort(a, i + 1, r);
        }
        return a;
    }
}
