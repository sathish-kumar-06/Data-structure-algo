package LeetcodeSearchingAndSorting;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] stalls = {6, 4, 3, 16, 20, 7, 18, 10};
        int cows = 5;
        Arrays.sort(stalls);

        int low = 1, high = stalls[stalls.length - 1] - stalls[0];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canWePlaceCows(stalls, mid, cows)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(high);
    }

    private static boolean canWePlaceCows(int[] stalls, int dist, int cows) {
        int cntCows = 1, last = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - last >= dist) {
                cntCows++;
                last = stalls[i];
            }
            if (cntCows >= cows) {
                return true;
            }
        }
        return false;
    }
}
