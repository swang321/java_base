package collection.sort;

import java.util.Arrays;

/**
 * @Date: 2019/1/14 15:40
 * @Description:
 * @Author admin
 */
public class ShellSort {

    public static void main(String[] args) {

        int[] arr = {21, 25, 49, 24, 16, 8};
        sort(arr,arr.length);
        System.out.println(Arrays.toString(arr));

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
            System.out.println(increment);
            sort(arr, increment);
        }
    }
}
