package string;

import org.w3c.dom.ls.LSOutput;

/**
 * @author wangyisu
 */
public class Solution20 {
    public static boolean isValid(String s) {
        int n = 0;
        while(s.length()!=0){
            n++;
            if(n==20000){
                return false;
            }
            s = s.replaceAll("\\(\\)","");
            s = s.replaceAll("\\{}","");
            s = s.replaceAll("\\[]","");
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}
