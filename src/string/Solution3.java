package string;

/**
 * @author wangyisu
 */
public class Solution3 {
    public static int lengthOfLongestSubstring(String s) {
        int lo = 0;
        int max_ = Integer.MIN_VALUE;
        while(lo<s.length()){
            int hi = lo;
            while(hi<s.length()){
                if (s.substring(lo, hi).indexOf(s.charAt(hi)) != -1) {
                    break;
                }else{
                    hi++;
                }
            }
            max_ = Math.max(max_,hi-lo);
            lo++;
        }
        return max_;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcdd"));
    }
}
