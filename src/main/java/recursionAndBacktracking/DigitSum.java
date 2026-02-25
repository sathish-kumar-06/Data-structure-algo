package recursionAndBacktracking;

public class DigitSum {
    public static void main(String[] args) {
        long n = 1234;
        System.out.println(digitSum(n));
    }

    private static long digitSum(long n) {
        if (n <= 0) return 0;

        return n % 10 + digitSum(n / 10);
    }
}
