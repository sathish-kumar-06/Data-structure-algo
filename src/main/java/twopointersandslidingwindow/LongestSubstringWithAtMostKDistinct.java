package twopointersandslidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinct {
    public static void main(String[] args) {
        String s = "abbbbbbc";
        int k = 2;
        System.out.println(findLongestSubstring(s, k));
    }

    private static int findLongestSubstring(String s, int k) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            while (map.size() > k) {
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                if (map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }
                left++;
            }
            int count = right - left + 1;
            maxLength = Math.max(maxLength, count);
            right += 1;
        }
        return maxLength;
    }
}
