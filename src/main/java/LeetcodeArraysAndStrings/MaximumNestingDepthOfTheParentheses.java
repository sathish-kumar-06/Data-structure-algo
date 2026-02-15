package LeetcodeArraysAndStrings;

public class MaximumNestingDepthOfTheParentheses {
    public static void main(String[] args) {
        String s= "(1+(2*3)+((8)/4))+1";
        int maxDepth=0;
        int currentDepth=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='(') {
                currentDepth+=1;
                maxDepth=Math.max(maxDepth,currentDepth);
            }else if(s.charAt(i)==')'){
                currentDepth-=1;
            }
        }
        System.out.println(maxDepth);
    }
}
