package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(generateParenthesis(n));
    }

    private static List<String> generateParenthesis(int n) {
        int open = 0, close = 0;
        String curr = "";
        List<String> res = new ArrayList<String>();
        return helper(n, curr, res, open, close);
    }

    private static List<String> helper(int n, String curr, List<String> res, int open, int close) {
        if (close == n && open == n) {
            res.add(curr);
            return res;
        }
        if (open < n) {
             helper(n, curr + "(", res, open + 1, close);
        }

        if (open > close) {
             helper(n, curr + ")", res, open, close + 1);
        }
        return res;
    }
}
