package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation2 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        System.out.println(permuteUnique(arr));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        boolean[] map = new boolean[nums.length];
        helper(nums, ans, currList, map);
        return ans;
    }

    private static void helper(int[] nums, List<List<Integer>> ans, List<Integer> currList, boolean[] map) {
        if (currList.size() == nums.length) {
            ans.add(new ArrayList<>(currList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !map[i - 1]) {
                continue;
            }
            if (!map[i]) {
                map[i] = true;
                currList.add(nums[i]);
                helper(nums, ans, currList, map);
                currList.removeLast();
                map[i] = false;
            }
        }
    }
}
