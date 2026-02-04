package LeetcodeSearchingAndSorting;

import java.util.Arrays;

public class KthSmallestPair {
    public static void main(String[] args) {
        int[] arr = {1, 3, 1};
        int k = 3;
        Arrays.sort(arr);
        System.out.println(binarySearch(arr, k));
    }

    private static int binarySearch(int[] arr, int k) {
        int low = 0, high = arr[arr.length - 1] - arr[0];
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countPairs(arr,mid) >= k){
                high= mid;
            }else{
                low = mid +1;
            }
        }
        return low;
    }

    private static int countPairs(int[] arr, int d) {
        int count =0,j=0;
        for (int i = 0; i < arr.length; i++) {
            while (j < arr.length && arr[j] - arr[i] <= d){
                j++;
            }
            count += j-i-1;
        }
        return count;
    }
}
