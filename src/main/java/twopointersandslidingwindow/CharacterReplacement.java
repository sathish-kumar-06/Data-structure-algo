package twopointersandslidingwindow;

public class CharacterReplacement {
    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(maxCharaterLength(s, k));
    }

    private static int maxCharaterLength(String s, int k) {
        int left = 0;
        int maxLength = 0;
        int maxFreq = 0;
        int[] freq = new int[26];
        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
