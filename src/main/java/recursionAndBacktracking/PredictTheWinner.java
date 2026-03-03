package recursionAndBacktracking;

public class PredictTheWinner {
    public static void main(String[] args) {
        int[] arr = {1, 5, 2};
        System.out.println(predictTheWinner(arr));
    }

    public static boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][n];
        int result = dfs(nums, 0, n - 1, dp);
        return result >= 0;
    }

    private static int dfs(int[] nums, int i, int j, Integer[][] dp) {

        if (i == j) {
            return nums[i];
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int pickLeft = nums[i] - dfs(nums, i + 1, j, dp);
        int pickRight = nums[j] - dfs(nums, i, j - 1, dp);

        dp[i][j] = Math.max(pickLeft, pickRight);

        return dp[i][j];
    }


}
