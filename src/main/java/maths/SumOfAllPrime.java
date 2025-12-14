package maths;

import java.util.Scanner;

public class SumOfAllPrime {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER");
        int n = scanner.nextInt();
        System.out.println(sumOfAllPrime(n));
    }

    private static int sumOfAllPrime(int n) {
        if (n == 0) return 0;
        int sum = 0;
        boolean[] b = new boolean[n+1];

        for (int i = 2; i <= n; i++) {
            if (!b[i]) {
                sum+=i;
                if ((long)i*i <= n){
                    for (int j = i*i; j <= n; j+=i) {
                        b[j]=true;
                    }
                }
            }
        }
        return sum;
    }
}
