package recursionAndBacktracking;

import java.util.*;

public class Combinations {

    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int i, int n, int k,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // ✅ If we picked k numbers
        if (k == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // ❌ If no numbers left
        if (i > n) {
            return;
        }

        // ❌ Pruning (important optimization)
        if (n - i + 1 < k) {
            return;
        }

        // 1️⃣ Include current number
        current.add(i);
        backtrack(i + 1, n, k - 1, current, result);
        current.remove(current.size() - i);  // backtrack

        // 2️⃣ Exclude current number
        backtrack(i + 1, n, k, current, result);
    }
}
