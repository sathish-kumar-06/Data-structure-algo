package LeetcodeArraysAndStrings;

import java.util.Arrays;

public class WaveArray {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,4};
        waveArray(arr);
    }

    private static void waveArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i += 2) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1]=temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
