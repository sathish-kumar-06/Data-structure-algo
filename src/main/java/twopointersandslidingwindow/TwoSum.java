package twopointersandslidingwindow;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {0, -1, 2, -3, 1};
        int target = -2;
        System.out.println(sumTarget(nums, target));
    }

    private static boolean sumTarget(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = target-nums[i];
            if (map.containsKey(sum)) {
                return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
}
