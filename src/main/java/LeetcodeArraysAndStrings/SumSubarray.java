package LeetcodeArraysAndStrings;

import java.util.*;

public class SumSubarray {
    public static void main(String[] args) {
        int[] arr ={1, 2, 3};
        System.out.println(subarraySum(arr));
    }
    public static int subarraySum(int[] arr) {
        int n = arr.length;
        long total = 0;

        for (int i = 0; i < n; i++) {
            total += (long) arr[i] * (i + 1) * (n - i);
        }

        return (int) total;
    }
}
