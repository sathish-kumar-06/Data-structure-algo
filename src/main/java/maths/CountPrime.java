package maths;

import java.util.Scanner;

public class CountPrime {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("ENTER THE NUMBER");
        int n = scanner.nextInt();
//        int res=countPrime(n);
        System.out.println(countPrime(n));
    }

    private static int countPrime(int n) {
        int count =0;
        int sum =0;
        if(n==0 || n==1) return 0;
        boolean[] b= new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!(b[i])) {
                count ++;
                sum+=i;
                for (int j = 2; i*j <n ; j++) {
                    b[i*j]= true;
                }
            }
        }
//        System.out.println(sum);
        return count;
    }
}
