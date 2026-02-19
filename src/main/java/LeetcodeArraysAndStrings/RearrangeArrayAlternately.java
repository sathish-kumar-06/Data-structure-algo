package LeetcodeArraysAndStrings;

import java.util.Arrays;

public class RearrangeArrayAlternately {
    public static void main(String[] args) {
        int[] arr = {890, 289, 483, 519, 550, 447, 946, 957, 92, 783
        };
        rearrange(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void rearrange(int[] arr) {
        int maxIndex = arr.length - 1;
        int minIndex = 0;

        int maxElement = arr[maxIndex] + 1;

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i] + (arr[maxIndex] % maxElement) * maxElement;
                maxIndex--;
            } else {
                arr[i] = arr[i] + (arr[minIndex] % maxElement) * maxElement;
                minIndex++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / maxElement;
        }

    }
}
