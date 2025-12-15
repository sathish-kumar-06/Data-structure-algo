package searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int len = arr.length;
        int key = -3;
        System.out.println(binarySearch(arr, len, key));
    }

    private static boolean binarySearch(int[] arr, int len, int key) {
        int start = 0;
        int end = len;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return true;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}
