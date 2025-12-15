package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 1, 2};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j-1];
        arr[j-1] = temp;
    }
}
