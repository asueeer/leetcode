package dp;

import java.util.Arrays;

/**
 * @author wangyisu
 */
public class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        // dp[m,n] = dp[m-1, n] dp[m, n-1]
        // if text1[m]==text2[n]:
        //    dp[m, n] = max(dp[m-1, n],dp[m, n-1], dp[m-1,n-1]+1)
        //              # 后来发现可以优化成 dp[m, n] = dp[m-1,n-1]+1
        // else:
        //    dp[m, n] = max(dp[m-1, n],dp[m, n-1])

        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for (int i = 0; i < text1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < text2.length(); i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < text1.length()+1; i++) {
            for (int j = 1; j < text2.length()+1; j++) {
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
//                    dp[i][j] = Math.max(dp[i-1][j-1] + 1, Math.max(dp[i-1][j], dp[i][j-1]));
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        Solution1143 solu = new Solution1143();
        System.out.println(solu.longestCommonSubsequence("abcde","ace"));
    }
}
