package sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 2, 4};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr, 0, last);
            swap(arr, maxIndex, last);
        }
    }

    private static int getMaxIndex(int[] arr, int start, int last) {
        int max = start;
        for (int j = start; j < last; j++) {
            if (arr[max] < arr[j]) {
                max = j;
            }
        }
        return max;
    }

    private static void swap(int[] arr, int maxIndex, int last) {
        int temp = arr[maxIndex];
        arr[maxIndex] = arr[last];
        arr[last] = temp;
    }
}
