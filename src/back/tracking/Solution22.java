package back.tracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @author wangyisu
 */
public class Solution22 {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        int left = n;
        int right = n;
        generate(n, result, left, right, "");
        return result;
    }

    private static void generate(int n, List<String> result, int left, int right, String str) {
        if(left==0 && right==0){
            result.add(str);
            return;
        }
        if(left==right){
            str+="(";
            left--;
            generate(n,result,left,right,str);
            return;
        }
        if(right>0 && right>left){
            String temp = new String(str);
            str+=")";
            right--;
            generate(n,result,left,right,str);

            right++;
            str = temp;
            if(left>0){
                str+="(";
                left--;
                generate(n,result,left,right,str);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
        System.out.println(generateParenthesis(2));
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(4));
    }
}