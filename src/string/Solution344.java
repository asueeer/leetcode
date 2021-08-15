package string;

/**
 * @author wangyisu
 */
public class Solution344 {
    public void reverseString(char[] s) {
        int lo = 0;
        int hi = s.length - 1;
        while (lo < hi){
            char temp = s[lo];
            s[lo] = s[hi];
            s[hi] = temp;
            lo++;
            hi--;
        }
    }

}
