package twopointersandslidingwindow;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));

    }

    public static String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        if (m == 0 || n == 0 || m > n) return "";

        // Frequency map for all ASCII chars
        int[] freq = new int[256];

        // Pre-insert all characters of t into the map
        for (int i = 0; i < m; i++) {
            freq[t.charAt(i)]++;
        }

        int left = 0, right = 0;
        int count = 0;                  // how many chars of t matched in current window
        int minLen = Integer.MAX_VALUE; // length of best window
        int start = -1;                 // starting index of best window found

        while (right < n) {
            char cRight = s.charAt(right);

            // If this char was needed (freq > 0), we increase matched count
            if (freq[cRight] > 0) {
                count++;
            }
            // We include this char in the window: decrease its freq (can go negative)
            freq[cRight]--;
            right++;

            // When we have all characters of t in the current window
            while (count == m) {
                // Update answer if this window is smaller
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                // Try to shrink from the left
                char cLeft = s.charAt(left);
                freq[cLeft]++;

                // If after incrementing, freq[cLeft] > 0, it means we just removed
                // a needed character from the window, so window is no longer valid
                if (freq[cLeft] > 0) {
                    count--;
                }

                left++;
            }
        }

        return start == -1 ? "" : s.substring(start, start + minLen);
    }
}
