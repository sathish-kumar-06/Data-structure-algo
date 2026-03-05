package twopointersandslidingwindow;

import java.util.HashMap;

public class TwoSumCountPairs {
    public static void main(String[] args) {
        int[] arr = {-17 ,-15 ,-13, -9, -4, 0, 0, 0, 1, 5, 9, 12, 18, 18};

        int target = 0;
        System.out.println(totalpairs(arr, target));
    }

    private static int totalpairs(int[] arr, int target) {
        int pairs = 0;
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int sum = arr[start] + arr[end];

            if (sum == target) {
                //A special condition because if start and end are equal inside all the elements are equal because its sorted
                if (arr[start] == arr[end]) {
                    int n = end- start +1;
                    pairs += n * (n - 1) / 2;
                    break;
                }

                int leftCount = 1;
                int rightCount = 1;
                while (start < end && arr[start] == arr[start + 1]) {
                    leftCount += 1;
                    start++;
                }
                while (end > start && arr[end] == arr[end - 1]) {
                    rightCount += 1;
                    end--;
                }
                pairs += leftCount * rightCount;
                start++;
                end--;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return pairs;
    }

}
