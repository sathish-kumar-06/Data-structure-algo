package recursionAndBacktracking;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        String[] s = {"H","a","n","n","a","h"};

        System.out.println(Arrays.toString(reverseString(s, 0, s.length - 1)));
    }

    private static String[] reverseString(String[] s, int start, int end) {
        if (end < start) {
            return s;
        }
        String temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        end--;
        start++;
        return reverseString(s, start, end);
    }
}
