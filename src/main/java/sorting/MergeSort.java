package sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        merge(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] merge(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = merge(Arrays.copyOfRange(arr, 0, mid));
        int[] right = merge(Arrays.copyOfRange(arr, mid, arr.length));

        return mergeSort(left, right);

    }

    private static int[] mergeSort(int[] first, int[] last) {

        int[] finalArr = new int[first.length + last.length];
        int i = 0;
        int j = 0;
        int k = 0;
        int count = 0;
        while (i < first.length && j < last.length) {
            if (first[i] < last[j]) {
                finalArr[k] = first[i];
                i++;
            } else {
                finalArr[k] = last[j];
                j++;
            }
            k++;
        }
        while (i < first.length) {
            finalArr[k] = first[i];
            i++;
            k++;
        }
        while (j < last.length) {
            finalArr[k] = first[j];
            j++;
            k++;
        }
        System.out.println(count);
        return finalArr;
    }

    private static void mergeInplace(int[] arr, int start, int end) {
        if (end - start == 1) {
            return;
        }

        int mid = (start + end) / 2;

        mergeInplace(arr, start, mid);
        mergeInplace(arr, mid, end);

        mergeSortInplace(arr, start, mid, end);

    }

    private static void mergeSortInplace(int[] arr, int start, int mid, int end) {
        int[] finalArr = new int[end - start];
        int i = start;
        int j = mid;
        int k = 0;

        while (i < mid && j < end) {
            if (arr[i] < arr[j]) {
                finalArr[k] = arr[i];
                i++;
            } else {
                finalArr[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i < mid) {
            finalArr[k] = arr[i];
            i++;
            k++;
        }
        while (j < end) {
            finalArr[k] = arr[j];
            j++;
            k++;
        }
        for (int l = 0; l < finalArr.length; l++) {
            arr[start + l] = finalArr[l];
        }
    }
}
