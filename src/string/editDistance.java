package string;

import static back.tracking.Solution37.print2DArray;

/**
 * @author wangyisu
 */
public class editDistance {
    public static int minDistance(String word1, String word2) {
        // 保证word2比word1短
        if(word2.length()>word1.length()){
            String temp = word1;
            word1 = word2;
            word2 = temp;
        }
        StringBuilder word2Builder = new StringBuilder(word2);
        for (int i = word2Builder.length(); i < word1.length(); i++) {
            word2Builder.append(" ");
        }
        System.out.println(word1);
        System.out.println(word2);
        word2 = word2Builder.toString();
        word1+="  ";
        word2+="  ";
//        dp(i,j) = min(dp(i+1,j+1)+1,dp(i+1,j)+1),if:word1[i]!=word2[j]
//                  min(dp(i+1,j+1), dp(i+1,j)+1),if:word1[i]==word2[j]
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = word1.length()-1; i > -1; i--) {
            for (int j = word2.length()-1; j > -1; j--) {
                if(word1.charAt(i)!=word2.charAt(j)){
                    dp[i][j] = Math.min(Math.min(dp[i+1][j+1],dp[i+1][j]),dp[i][j+1])+1;
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i+1][j+1],dp[i+1][j]+1),dp[i][j+1]+1);
                }
            }
        }
        return dp[0][0];
    }


    //  复杂度太高，而且是错的，没有考虑到增加字符的操作
    private static int min_;

    public static int minDistance_(String word1, String word2) {
        min_ = Math.max(word1.length(),word2.length());
        findMinDistance(word1, word2, 0);
        return min_;
    }

    public static void findMinDistance(String word1, String word2, int result){
        if(result>=min_){
            return;
        }
        if(word1.length()==0 && word2.length()==0){
            if(result<min_){
                min_ = result;
            }
            return;
        }

        if(word2.length()>word1.length()){
            String temp = word1;
            word1 = word2;
            word2 = temp;
        }
        if(word2.length()==0){
            result+=word1.length();
            findMinDistance("","", result);
            return;
        }

        if(word1.charAt(0)==word2.charAt(0)){
            findMinDistance(word1.substring(1),word2.substring(1),result);
        }else{
            findMinDistance(word1.substring(1),word2.substring(1),result+1);
        }
        findMinDistance(word1.substring(1),word2,result+1);
    }

    public static void main(String[] args) {
        System.out.println(minDistance("teacher","techier"));
        System.out.println(minDistance("techier","teacher"));
//        System.out.println(minDistance("ab","bc"));
//        System.out.println(minDistance("horse","ros"));
//        System.out.println(minDistance("park","spake"));
//        System.out.println(minDistance("pneumonoultramicroscopicsilicovolcanoconiosis","ultramicroscopically"));
    }
}
