package stackandqueue;

import java.util.EmptyStackException;
import java.util.Stack;

public class MinStack {
    private static Stack<Integer> stack = null;
    private static Stack<Integer> minStack = null;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public static void push(int val) {
        stack.push(val);

        if (minStack.isEmpty()) {
            minStack.push(val);
        }else if (val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public static void pop() {
        int removed=stack.pop();
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }

    public static int top() {
        return stack.peek();
    }

    public static int getMin() {
        return minStack.peek();
    }
}
