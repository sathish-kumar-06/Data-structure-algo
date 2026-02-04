package LeetcodeSearchingAndSorting;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5};
        int target = 2;
        System.out.println(search(arr, target));
    }

    private static int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
