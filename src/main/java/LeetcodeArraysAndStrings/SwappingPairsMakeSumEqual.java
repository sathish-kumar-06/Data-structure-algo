package LeetcodeArraysAndStrings;

import java.util.Arrays;
import java.util.HashSet;

public class SwappingPairsMakeSumEqual {
    public static void main(String[] args) {
        int[] a = {5, 7, 4, 6};
        int[] b = {1, 2, 3, 8};
        System.out.println(swappingPairsMakeSumEqual(a, b));
    }

    private static boolean swappingPairsMakeSumEqual(int[] a, int[] b) {
        long sumA = 0, sumB = 0;
        for (int x : a) sumA += x;
        for (int x : b) sumB += x;
        if ((sumA - sumB) % 2 != 0) return false;
        long target = (sumA - sumB) / 2;

        HashSet<Integer> setA = new HashSet<>();
        for (int x : a) setA.add(x);
        for (int y : b) {
            if (setA.contains((int) (y + target))) return true;
        }
        return false;
    }
}
