package twopointersandslidingwindow;

public class MaxPointFromCards {
    public static void main(String[] args) {
        int[] arr = {11, 49, 100, 20, 86, 29, 72};
        int k = 4;
        System.out.println(findTheSumOfcards(arr, k));
    }

    private static int findTheSumOfcards(int[] arr, int k) {
        int leftSum = 0;
        int rightSum = 0;
        int maxSum = 0;

        for (int i = 0; i < k; i++) {
            leftSum += arr[i];
        }
        maxSum = leftSum;

        int rightIndex = arr.length - 1;
        for (int i = k - 1; i >= 0; i--) {
            leftSum -= arr[i];
            rightSum += arr[rightIndex];
            rightIndex -= 1;
            maxSum= Math.max(maxSum,leftSum+rightSum);
        }
        return maxSum;
    }
}
