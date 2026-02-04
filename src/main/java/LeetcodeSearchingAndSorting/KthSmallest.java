package LeetcodeSearchingAndSorting;

import java.util.Arrays;

public class KthSmallest {

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int n = arr.length;
        int k = 3;

        System.out.println(kthSmallest(arr, k, n));
    }

    private static int kthSmallest(int[] arr, int k, int n) {
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int countless = 0, countequal = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] < mid) {
                    countless++;
                } else if (arr[i] == mid) {
                    countequal++;
                }
            }

            if (countless < k && (countless + countequal) >= k) {
                return mid;
            } else if (countless >= k) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return -1;
    }
}
