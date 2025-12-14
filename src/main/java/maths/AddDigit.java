package maths;

import java.util.Scanner;

public class AddDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER");
        int n = scanner.nextInt();
        System.out.println(addDigit(n));
    }

    private static int addDigit(int n) {
        if (n == 0) return 0;
        return 1 + (n - 1) % 9;
    }
}
