package maths;

import java.util.Scanner;

public class CommonFactors {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("ENTER A");
        int a = scanner.nextInt();
        System.out.println("ENTER B");
        int b = scanner.nextInt();
        System.out.println(commonFactors(a,b));
    }

    private static int commonFactors(int a,int b) {
        int n = Math.max(a, b);
        int count =0;
        for (int i = 1; i < n; i++) {
            if (a %i== 0 && b%i==0) {
                count+=1;
            }
        }

        return count;
    }
}
