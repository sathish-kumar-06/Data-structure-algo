package stackandqueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(getLastStone(nums));
    }

    private static int getLastStone(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : nums) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            int x = queue.poll();
            int y = queue.poll();

            if (x != y) {
                queue.add(x - y);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }
}
