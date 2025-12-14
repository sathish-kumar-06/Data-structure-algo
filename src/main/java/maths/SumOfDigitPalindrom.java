package maths;

import java.util.Scanner;

public class SumOfDigitPalindrom {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER");
        int n = scanner.nextInt();
        System.out.println(sumOfDigitPalindrom(n));
    }

    private static boolean sumOfDigitPalindrom(int n) {
        int sum = 0;
        while (n > 0) {
            sum = sum + (n % 10);
            n /= 10;
        }

        int original = sum;
        int rev = 0;
        while (sum > 0) {
            rev = rev * 10 + (sum % 10);
            sum /= 10;
        }
        return original == rev;
    }
}
