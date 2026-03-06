package twopointersandslidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3};
        int k = 2;
        int count = subArray(arr, k) - subArray(arr, k - 1);
        System.out.println(count);
    }


    private static int subArray(int[] arr, int k) {
        int left = 0, right = 0, count = 0, n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        while (right < n) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            while (map.size() > k) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }
            count += right - left + 1;
            right += 1;
        }

        return count;
    }
}

