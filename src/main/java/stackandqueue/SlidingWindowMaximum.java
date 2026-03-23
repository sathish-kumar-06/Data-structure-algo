package stackandqueue;

import java.util.*;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return new int[0];

        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>(); // stores indices

        int idx = 0;
        for (int i = 0; i < n; i++) {

            // 1) Remove indices which are out of this window (i - k + 1 is window start)
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // 2) Maintain decreasing order in deque (values)
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            // 3) Add current index
            dq.offerLast(i);

            // 4) Once first window is formed, start recording answers
            if (i >= k - 1) {
                ans[idx++] = nums[dq.peekFirst()];
            }
        }

        return ans;
    }

    // small driver to test
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res)); // [3, 3, 5, 5, 6, 7]
    }
}

