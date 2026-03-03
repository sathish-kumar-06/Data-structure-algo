package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {
    public static void main(String[] args) {
        int[] arr = {0};
        Arrays.sort(arr);
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        solve(arr, 0, curList, resultList);
        System.out.println(resultList);
    }

    private static void solve(int[] arr, int start, List<Integer> curList, List<List<Integer>> resultList) {
        resultList.add(new ArrayList<>(curList));
        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1]) {
                continue;
            }
            curList.add(arr[i]);

            solve(arr, i + 1, curList, resultList);
            curList.remove(curList.size() - 1);
        }
    }
}
