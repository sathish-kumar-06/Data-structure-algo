package LeetcodeArraysAndStrings;

public class SubstringsWithKDistinct {

    public static int substringsWithKDistinct(String s, int k) {
        if (k <= 0) return 0;

        return atMostK(s, k) - atMostK(s, k - 1);
    }

    private static int atMostK(String s, int k) {
        if (k < 0) {
            return 0;
        }
        int left = 0, count = 0, distinct = 0;

        int[] freq = new int[26];
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (freq[ch - 'a'] == 0) {
                distinct++;
            }
            freq[ch - 'a']++;

            while (distinct > k) {
                char leftChar = s.charAt(left);
                freq[leftChar - 'a']--;
                if (freq[leftChar - 'a'] == 0) {
                    distinct--;
                }
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "pqpqs";
        int k = 2;

        System.out.println(substringsWithKDistinct(s, k));
    }
}