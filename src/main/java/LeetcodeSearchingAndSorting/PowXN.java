package LeetcodeSearchingAndSorting;

public class PowXN {
    public static void main(String[] args) {
        double x= 2.00000;
        int n =-2;

        System.out.println(findPow(x,n));
    }

    private static double findPow(double x, int n) {
        return Math.pow(x,n);
    }
}
