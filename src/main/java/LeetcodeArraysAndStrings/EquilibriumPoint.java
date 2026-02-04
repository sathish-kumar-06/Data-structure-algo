package LeetcodeArraysAndStrings;

public class EquilibriumPoint {
    public static void main(String[] args) {
        int[] arr= {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(equilibriumPoint(arr));
    }

    private static int equilibriumPoint(int[] arr) {
        int n = arr.length;

        int totalSum = 0;
        for (int x : arr) {
            totalSum += x;
        }

        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - arr[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += arr[i];
        }

        return -1;
    }
}
