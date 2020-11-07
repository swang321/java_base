package collection.sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 * @Date: 2019/1/14 15:40
 * @Description: 希尔(shell)排序
 * @Author admin
 */
public class ShellSort {

    public static void main(String[] args) throws FileNotFoundException {
        int[] arr = {21, 25, 49, 24, 16, 8, 29, 65, 35, 14, 26, 18, 27, 96, 35, 36, 37, 39, 33, 40, 16, 3, 7, 5, 10};
        sort(arr, arr.length);
//        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int increment) {
        while (increment > 1) {
            increment = increment / 3 + 1;
            for (int i = increment; i < arr.length; i++) {
                int front = arr[i - increment];
                int rear = arr[i];
                if (front > rear) {
                    arr[i - increment] = rear;
                    arr[i] = front;
                }
            }
            System.out.println("increment: " + increment + "  " + Arrays.toString(arr));
            sort(arr, increment);
        }
    }
}
