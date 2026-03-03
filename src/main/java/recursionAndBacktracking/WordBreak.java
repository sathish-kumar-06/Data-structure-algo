package recursionAndBacktracking;

import java.util.*;

public class WordBreak {

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats","dog","sand","and","cat");
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        // Convert list to HashSet for O(1) lookup
        Set<String> set = new HashSet<>(wordDict);

        // Memo array to avoid recomputation
        Boolean[] memo = new Boolean[s.length()];

        return dfs(s, 0, set, memo);
    }

    private static boolean dfs(String s, int start, Set<String> set, Boolean[] memo) {

        // Base case: successfully segmented entire string
        if (start == s.length()) {
            return true;
        }

        // If already computed, return stored result
        if (memo[start] != null) {
            return memo[start];
        }

        // Try every possible end position
        for (int end = start + 1; end <= s.length(); end++) {

            String prefix = s.substring(start, end);

            if (set.contains(prefix) && dfs(s, end, set, memo)) {
                memo[start] = true;
                return true;
            }
        }

        // If no valid segmentation found
        memo[start] = false;
        return false;
    }
}
