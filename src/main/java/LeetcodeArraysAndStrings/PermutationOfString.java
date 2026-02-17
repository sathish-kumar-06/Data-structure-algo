package LeetcodeArraysAndStrings;

import java.util.Arrays;

public class PermutationOfString {
    public static void main(String[] args) {
        String s1="ab";
        String s2="eidbaooo";
        System.out.println(checkInclusion(s1,s2));
    }
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] map = new int[26];
        for (char c : s1.toCharArray()) {
            System.out.println(c);
            map[c - 'a']++;
        }

        System.out.println(Arrays.toString(map));
        int j = 0, i = 0;
        int count_chars = s1.length();
        while (j < s2.length()) {
            if (map[s2.charAt(j++) - 'a']-- > 0)
                count_chars--;
            if (count_chars == 0)
                return true;
            if (j - i == s1.length() && map[s2.charAt(i++) - 'a']++ >= 0)
                count_chars++;
        }
        return false;
    }
}
