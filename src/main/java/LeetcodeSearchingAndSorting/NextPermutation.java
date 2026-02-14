package LeetcodeSearchingAndSorting;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr={1,3,2};
        nextPermutation(arr);
    }

    public static void nextPermutation(int[] nums) {
        int len= nums.length;
        int index=-1;
        for (int i = len-2; i >=0 ; i--) {
            if (nums[i] < nums[i+1]) {
                index=i;
                break;
            }
        }
        if (index == -1){
            Arrays.sort(nums);
            return;
        }

        for (int i = len-1; i >index ; i--) {
            if (nums[i] > nums[index]) {
                int temp = nums[i];
                nums[i]=nums[index];
                nums[index]=temp;
//                swap(nums[i],nums[index],nums);
                break;
            }
        }
        Arrays.sort(nums, index+1, nums.length);
        System.out.println(Arrays.toString(nums));

    }

    private static int[] sort(int[] nums, int index) {
        for (int i = index+1; i < nums.length ; i++) {
            if (nums[i]>nums[i+1]){
                swap(nums[i],nums[i+1],nums);
                break;
            }
        }
        return nums;
    }

    private static void swap(int i, int j,int [] nums) {
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
