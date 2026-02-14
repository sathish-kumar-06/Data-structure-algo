package LeetcodeSearchingAndSorting;

import java.util.Arrays;

public class ManHattanDistance {
    public static void main(String[] args) {
        int[] x = {-1, 1, 3, 2};
        int[] y = {5, 6, 5, 3};
        int n = x.length;
        System.out.println(totalDistance(x, y, n));
    }

    private static int totalDistance(int[] x, int[] y, int n) {
        return sumOfDistance(x, n) + sumOfDistance(y, n);
    }

    private static int sumOfDistance(int[] arr, int n) {
        Arrays.sort(arr);
        int preSum = 0, dis = 0;

        for (int i = 0; i < n; i++) {
            dis+=(arr[i]*i)-preSum;
            preSum+=arr[i];
        }

        return dis;
    }
}
