package LeetcodeArraysAndStrings;

public class MinimumSwapsAndKTogether {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 3, 6, 1, 8};
        int k = 6;
//        minSwap(arr, k);
        System.out.println(minSwap(arr, k));
    }

    private static int minSwap(int[] arr, int k) {
        int n = arr.length;

        int good = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= k) {
                good += 1;
            }
        }

        if (good == 0 || good == n) return 0;

        int bad = 0;

        for (int i = 0; i < good; i++) {
            if (arr[i] > k) {
                bad++;
            }
        }
        int ans = bad;
        for (int i = 1; i < n - good; i++) {
            //remove left element
            if (arr[i - 1] > k) {
                bad--;
            }

            if (arr[i + good - 1] > k) {
                bad++;
            }

            ans = Math.min(ans, bad);
        }

        return ans;
    }
}
