package stackandqueue;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {6, 8, 0, 1, 3};
        System.out.println(nextLargerElement(arr));
    }

    public static ArrayList<Integer> nextLargerElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) ans.add(-1);

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                ans.set(i, st.peek());
            } else {
                ans.set(i, -1);
            }
            st.push(arr[i]);
        }
        return ans;

    }
}
