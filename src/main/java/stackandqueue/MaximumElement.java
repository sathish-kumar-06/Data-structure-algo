package stackandqueue;

import java.util.*;

public class MaximumElement {
    public static void main(String[] args) {
        List<String> operations = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            operations.add("1");
            operations.add("2");
            operations.add("3");
        }
        System.out.println(getMax(operations));
    }

    public static List<Integer> getMax(List<String> operations) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> maxStack = new ArrayDeque<>();

        for (String op : operations) {
            if (op.charAt(0) == '1') {
                int x = Integer.parseInt(op.substring(2));
                stack.push(x);
                maxStack.push(maxStack.isEmpty() ? x : Math.max(x, maxStack.peek()));
            } else if (op.charAt(0) == '2') {
                stack.pop();
                maxStack.pop();
            } else {
                result.add(maxStack.peek());
            }
        }

        return result;
    }
}
