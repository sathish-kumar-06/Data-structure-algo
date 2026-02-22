package LeetcodeArraysAndStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PermutationSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(getPermutation(n, k));
    }

    public static String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;
        for (int i = 1 ; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);
        k = k - 1;
        StringBuilder ans = new StringBuilder();
        while (true) {
            ans.append(numbers.get(k / fact));
            numbers.remove(k / fact);
            if (numbers.isEmpty()) {
                break;
            }

            k = k % fact;
            fact = fact / numbers.size();
        }


        return ans.toString();
    }
}
