package recursionAndBacktracking;

public class PowerOf2 {
    public static void main(String[] args) {
        int n = 1;
        System.out.println(powerOfTwo(n, 2));
    }

    private static boolean powerOfTwo(int n, int pow) {
        if (n == pow || n == 1) return true;
        if (pow > n) return false;

        return powerOfTwo(n, (pow * 2));
    }
}
