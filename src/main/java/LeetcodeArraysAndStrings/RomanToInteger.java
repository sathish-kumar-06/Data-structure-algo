package LeetcodeArraysAndStrings;

public class RomanToInteger {
    public static void main(String[] args) {
        String s = "IV";
        int total = 0;

        for (int i = 0; i < s.length(); i++) {

            int current = value(s.charAt(i));

            if (i < s.length() - 1 && current < value(s.charAt(i + 1))) {
                total -= current;
            } else {
                total += current;
            }
        }

        System.out.println(total);
    }

    public static int value(char ch) {
        int value = 0;
        switch (ch) {
            case 'I':
                value = 1;
                break;
            case 'V':
                value = 5;
                break;
            case 'X':
                value = 10;
                break;
            case 'L':
                value = 50;
                break;
            case 'C':
                value = 100;
                break;
            case 'D':
                value = 500;
                break;
            case 'M':
                value = 1000;
                break;
            default:
                value = 0;
        }
        return value;
    }
}
