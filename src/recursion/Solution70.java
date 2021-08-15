package recursion;

/**
 * @author wangyisu
 */
public class Solution70 {
    public class Fibonacci {
        public int fib(int n) {
            int[] dp = new int[n*2];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i < dp.length; i++) {
                dp[i] = (dp[i-1] + dp[i-2]);
            }
            return dp[n];
        }
    }
    public int climbStairs(int n) {
        Fibonacci fibonacci = new Fibonacci();
        return fibonacci.fib(n+1);
    }
}