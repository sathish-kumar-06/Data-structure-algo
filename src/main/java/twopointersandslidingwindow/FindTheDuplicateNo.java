package twopointersandslidingwindow;

public class FindTheDuplicateNo {
    public static void main(String[] args) {
        int[] n = {1, 3, 4, 2, 2};
        System.out.println(findADuplicate(n));
    }

    private static int findADuplicate(int[] n) {
        int slow = 0;
        int fast = 0;

        do {
            slow = n[slow];
            fast = n[n[fast]];
        } while (slow != fast);

        slow = 0;

        while (slow != fast) {
            slow = n[slow];
            fast = n[fast];
        }
        return slow;
    }
}
