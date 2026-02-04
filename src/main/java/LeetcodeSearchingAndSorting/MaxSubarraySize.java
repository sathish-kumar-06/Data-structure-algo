package LeetcodeSearchingAndSorting;

import java.util.*;

public class MaxSubarraySize {
    static int maxSubarraySize(int[] arr, int k) {
        int low = 1, high = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int sum = 0;
            int maxSum = Integer.MIN_VALUE;

            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];

                if (i >= mid) {
                    sum -= arr[i - mid];
                }
                if (i >= (mid - 1)) {
                    maxSum = Math.max(maxSum, sum);
                }
            }

            if (maxSum <= k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (high == 0) {
            return -1;
        }
        return high;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 8;
        System.out.println(maxSubarraySize(arr, k));
    }
}