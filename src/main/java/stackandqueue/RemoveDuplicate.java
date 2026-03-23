package stackandqueue;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveDuplicate {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(removeDuplicate(s));
    }

    private static String removeDuplicate(String s) {

        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        Set<Character> inStack = new HashSet<>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            count[ch - 'a']--;

            if (inStack.contains(ch)) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > ch && count[stack.peek() - 'a'] > 0) {
                char remmoved =stack.pop();
                inStack.remove(remmoved);
            }

            stack.push(ch);
            inStack.add(ch);

        }

        for (char c : stack) {
            builder.append(c);
        }

        return builder.toString();
    }
}
