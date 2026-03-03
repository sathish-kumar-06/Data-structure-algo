package recursionAndBacktracking;

public class CountTheGoodNumber {
    final static long MOD = 1_000_000_007;
    public static void main(String[] args) {
        long n = 4;
//        System.out.println(countGoodNumbers(n, 0));
        System.out.println(countGoodNumbersWithPower(n));
    }

    public static long countGoodNumbers(long n, long index) {
        if (n == index) {
            return 1;
        }
        if (index % 2 == 0) {
            return 5 * countGoodNumbers(n, index+1);
        } else {
            return 4 * countGoodNumbers(n,index+1);
        }
    }
    public static long countGoodNumbersWithPower(long n) {
        long evenCount = (n+1)/2;
        long oddCount = n/2;

        long evenPart=power(5,evenCount);
        long oddPart=power(4,oddCount);

        return (evenPart*oddPart)%MOD;
    }

    private static long power(long base, long exp) {
        long result=1;

        while (exp>0){
            if ((exp&1) == 1) {
                result=(result*base)%MOD;
            }
            base=(base*base)%MOD;
           exp= exp>>1;
        }
        return result;
    }

}
