package collection.sort;

import java.util.Arrays;

/**
 * @Author whh
 */
public class QuickSort1 {

    public static void main(String[] args) {

        int[] arr = { 66, 13, 51, 76, 81, 26, 57, 69, 93};

        int[] sort = quickSort(arr, 0, arr.length - 1);
    }


    private static int[] quickSort(int[] arr, int left, int right) {

        int temp = arr[left];
        if (left < right) {
            while (left <= right) {
                while (left < right && arr[right] > temp) {
                    right--;
                }
                if (arr[right] < temp) {
                    arr[left] = arr[right];
                    left++;
                }
                while (left < right && arr[left] < temp) {
                    left++;
                }
                if (arr[left] > temp) {
                    arr[right] = arr[left];
                    right--;
                }
            }
            arr[left] = temp;
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

}
