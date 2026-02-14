package LeetcodeSearchingAndSorting;

import java.util.Arrays;
import java.util.HashMap;

public class SortingElementsOfAnArrayByFrequency {
    public static void main(String[] args) {
        int[] arr = {5, 5, 4, 6, 4};
        int len = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Integer[] nums = new Integer[len];
        for (int i = 0; i < len;i++){
            nums[i]=arr[i];
        }

        Arrays.sort(nums,(a,b) ->{
            int freqA= map.get(a);
            int freqB= map.get(b);

            if (freqA==freqB){
                return a-b;
            }
            return freqB-freqA;
        });

        System.out.println(Arrays.toString( nums));
    }
}
