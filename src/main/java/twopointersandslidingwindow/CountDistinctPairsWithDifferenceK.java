package twopointersandslidingwindow;

import java.util.HashMap;

public class CountDistinctPairsWithDifferenceK {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5};
        int target = 2;
        System.out.println(totalpairs(arr, target));
    }

    private static int totalpairs(int[] arr, int target) {
        int pairs = 0;
        if (target < 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        if (target == 0) {
            for (int m : map.values()) {
                if (m > 1) {
                    pairs += 1;
                }
            }
        } else {
            for (int m : map.keySet()) {
                int sum = m + target;
                if (map.containsKey(sum)) {
                    pairs += 1;
                }
            }

        }
        return pairs;
    }

}