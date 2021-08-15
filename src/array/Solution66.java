package array;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author wangyisu
 */
public class Solution66 {
    public int[] plusOne(int[] digits) {
        BigInteger num = numberOf(digits);
        System.out.println(num);
        num = num.add(BigInteger.valueOf(1));
        return arrayOf(num);
    }

    private int[] arrayOf(BigInteger num) {
        String number = String.valueOf(num);
        int[] result = new int[number.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(number.substring(i,i+1));
        }
        return result;
    }

    public BigInteger numberOf(int[] digits) {
        BigInteger result = BigInteger.valueOf(0);
        for (int i = 0; i < digits.length; i++) {
            // result = result + 10^digit[i]
            result = result.add(BigInteger.valueOf(10).pow(digits.length - i - 1).multiply(BigInteger.valueOf(digits[i])));
        }
        return result;
    }

    public static void main(String[] args) {
        Solution66 solu = new Solution66();
//        System.out.println(Arrays.toString(solu.plusOne(new int[]{1, 2, 3})));
//        System.out.println(solu.numberOf(new int[]{1,2,3}));
//        System.out.println(Arrays.toString(solu.plusOne(new int[]{9,8,7,6,5,4,3,2,1,0})));
        System.out.println(Arrays.toString(solu.plusOne(new int[]{7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6})));
    }
}
