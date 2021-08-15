package greedy;


import java.math.BigInteger;

public class Solution402 {

    public String removeKdigits(String num, int k) {
        while (k > 0) {
            // todo
            BigInteger choice1 = new BigInteger(num.substring(1));
            BigInteger choice2 = new BigInteger(num.charAt(0) + num.substring(2));
//            choice1.
            num = String.valueOf(new BigInteger(num));
            k--;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution402 solu = new Solution402();

        System.out.println();
        // 1219
        System.out.println(solu.removeKdigits("1432219", 3));
//        // 200
//        System.out.println(solu.removeKdigits("10200", 1));
//        // 0
//        System.out.println(solu.removeKdigits("10", 2));
    }
}
