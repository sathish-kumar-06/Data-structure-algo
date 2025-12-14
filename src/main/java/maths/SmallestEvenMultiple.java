package maths;

import java.util.Scanner;

public class SmallestEvenMultiple {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER A NUMBER");
        int n = scanner.nextInt();
        System.out.println(smallestEvenMultiple(n));
    }

    private static int smallestEvenMultiple(int n) {
        return (n % 2 == 0) ? n : 2 * n;
    }
}
