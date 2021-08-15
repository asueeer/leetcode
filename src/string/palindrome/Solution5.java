package string.palindrome;

/**
 * @author wangyisu
 */
public class Solution5 {
    // 暴力解法
    public static boolean isPalindrome(String s){
        int lo = 0;
        int hi = s.length()-1;
        while(lo<=hi){
            if(s.charAt(lo)!=s.charAt(hi)){
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }

    public static String longestPalindrome(String s) {
//        if(s.length()==1){
//            return s;
//        }
        int max_ = -1;
        String record = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + max_ + 1; j < s.length(); j++) {
                if(isPalindrome(s.substring(i,j+1))){
                    max_ = j - i;
                    record = s.substring(i,j+1);
                }
            }
        }
        return record;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ac"));
    }
}
