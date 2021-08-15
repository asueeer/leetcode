package string;

/**
 * @author wangyisu
 */
public class Solution58 {
    public int lengthOfLastWord(String s) {
        int result = 0;
        for (int i = s.length() -1; i > -1 ;i--) {
            if(s.charAt(i)!=' '){
                result++;
            }
        }
        return result;
    }
}
