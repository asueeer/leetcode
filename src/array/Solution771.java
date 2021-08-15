package array;

import java.util.HashSet;

/**
 * @author wangyisu
 */
public class Solution771 {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> Js = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            Js.add(J.charAt(i));
        }
        int result = 0;
        for (int i = 0; i < S.length(); i++) {
            if(Js.contains(S.charAt(i))){
                result++;
            }
        }
        return result;
    }
}
