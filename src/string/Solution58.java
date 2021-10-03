package string;

/**
 * @author wangyisu
 */
public class Solution58 {
    public int lengthOfLastWord(String s) {
        // trim space
        int end = s.length() - 1;
        for (int i = s.length() - 1; i > -1; i--) {
            if (s.charAt(i) == ' ') {
                end--;
            } else {
                break;
            }
        }

        int result = 0;
        for (int i = end; i > -1; i--) {
            if (s.charAt(i) != ' ') {
                result++;
            }
            if (s.charAt(i) == ' ') {
                break;
            }
        }
        return result;
    }
}
