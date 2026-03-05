package twopointersandslidingwindow;

import java.util.Arrays;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] charIndex = new int[128];
        Arrays.fill(charIndex, -1);
        int left = 0;
        int right = 0;
        while (right < n) {
            if (charIndex[s.charAt(right)] != -1) {
                if (charIndex[s.charAt(right)] >= left) {
                    left = charIndex[s.charAt(right)] + 1;
                }
            }
            int currentLength = right - left + 1;
            maxLength = Math.max(currentLength, maxLength);
            charIndex[s.charAt(right)] = right;
            right++;
        }
        return maxLength;
    }
}
