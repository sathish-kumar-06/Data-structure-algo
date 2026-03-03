package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {
    public static void main(String[] args) {
        int[] candidate = {2, 3, 6, 7};
        int target = 7;
        List<Integer> currenList = new ArrayList<>();
        List<List<Integer>> ansLists = new ArrayList<>();
        findCombination(0, candidate, target, currenList, ansLists);
        System.out.println(ansLists);
    }

    private static void findCombination(int i, int[] arr, int target, List<Integer> currenList, List<List<Integer>> ansLists) {
        if (arr.length == i){
            if (target == 0) {
                ansLists.add(new ArrayList<>(currenList));
            }
            return;
        }

        if (arr[i] <= target){
            currenList.add(arr[i]);
            findCombination(i,arr,target-arr[i],currenList,ansLists);
            currenList.removeLast();
        }
        findCombination(i+1,arr,target,currenList,ansLists);
    }
}
