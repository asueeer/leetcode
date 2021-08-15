package recursion;

import javax.crypto.spec.PSource;

/**
 * @author wangyisu
 */
public class Fibonacci {
    public static int fib(int n) {
        int[] dp = new int[n*2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%1000000007;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(2));
        System.out.println(fib(45));
        // 48往后就溢出了
        System.out.println(fib(48));
    }
}
