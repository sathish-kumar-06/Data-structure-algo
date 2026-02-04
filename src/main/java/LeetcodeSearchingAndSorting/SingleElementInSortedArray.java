package LeetcodeSearchingAndSorting;

public class SingleElementInSortedArray {

    public static void main(String[] args) {
        int[] numbs = {1, 1, 2,2, 3, 4, 4, 8, 8};
        System.out.println(findSingleElementInSortedArray(numbs));
    }

    private static int findSingleElementInSortedArray(int[] numbs) {
        int start = 0;
        int end = numbs.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (numbs[mid] != numbs[mid + 1]) {
                end = mid;
            } else {
                start = mid + 2;
            }
        }

        return numbs[start];
    }
}
