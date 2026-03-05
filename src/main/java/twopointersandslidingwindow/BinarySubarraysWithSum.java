package twopointersandslidingwindow;

public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        int ans = atMost(nums, goal) - atMost(nums, goal - 1);
        System.out.println(ans);
    }

    private static int atMost(int[] nums, int goal) {
        if (goal < 0) return 0;
        int n = nums.length;
        int left = 0;
        int count = 0;
        int sum = 0;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}
