package LeetcodeArraysAndStrings;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1};
        Arrays.sort(arr);
        int missing = findMissing(arr);
        if (missing == -1) {
            System.out.println(arr.length + 1);
        } else {
            System.out.println(missing);
        }
    }

    private static int findMissing(int[] arr) {
        for (int i = 0; i < arr.length; ) {
            int count = i + 1;
            if (arr[i] != count) {
                return count;
            }
            i++;

        }
        return -1;
    }
}
