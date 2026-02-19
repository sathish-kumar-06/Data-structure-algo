package LeetcodeArraysAndStrings;

public class MaxCircularSubarraySum {
    public static void main(String[] args) {
        int[] arr = {5, -3, 5};
        int len = arr.length;
        System.out.println(maxSub(arr, len));
    }

    private static int maxSub(int[] arr, int len) {
        int n = arr.length;
        int max = Integer.MIN_VALUE, min = 0, sum = 0, curMax = 0, curMin = 0;
        for (int num : arr) {
            curMax = Math.max(curMax + num, num);
            max = Math.max(max, curMax);
            curMin = Math.min(curMin + num, num);
            min = Math.min(min, curMin);
            sum += num;
        }
        return max >= 0 ? Math.max(max, sum - min) : max;
    }
}
