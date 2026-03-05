package twopointersandslidingwindow;

public class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int k = 2;
        int ans = atMost(nums, k) - atMost(nums, k - 1);
        System.out.println(ans);
    }

    private static int atMost(int[] nums, int k) {
        if (k < 0) return 0;
        int n = nums.length;
        int left = 0;
        int count = 0;
        int sum = 0;
        for (int right = 0; right < n; right++) {
            sum += nums[right] % 2;
            while (sum > k) {
                sum -= nums[left] % 2;
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}
