package twopointersandslidingwindow;

public class MaxConsicutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(longestOnes(nums, k));
    }

    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int zeros = 0;
        int maxLength = 0;
        while (right < nums.length) {
            if (nums[right] == 0) zeros += 1;
            if (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            if (zeros <= k) {
                int len = right - left + 1;
                maxLength = Math.max(maxLength, len);
            }
            right += 1;
        }
        return maxLength;
    }
}
