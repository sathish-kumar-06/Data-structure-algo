package LeetcodeArraysAndStrings;

public class MaxChunksToMakeSorted {
    public static void main(String[] args) {
        int[] arr = {0,2,1};
        System.out.println(countChunks(arr));
    }

    private static int countChunks(int[] arr) {
        int maxSofar = arr[0];
        int chunks = 0;
        for (int i = 0; i < arr.length; i++) {
            maxSofar = Math.max(maxSofar, arr[i]);
            if (maxSofar == i) {
                chunks++;
            }
        }
        return chunks;
    }
}
