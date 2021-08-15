package string;

import java.math.BigDecimal;

/**
 * @author wangyisu
 */
public class Solution7 {
    public static int reverse(int x) {
        boolean negative = false;
        if(x<0){
            x*=-1;
            negative = true;
        }
        String s = Integer.toString(x);
        String temp = "";
        for (int i = s.length()-1; i > -1; i--) {
            temp+=s.charAt(i);
        }
        s = temp;
        try {
            if(negative==false){
                return Integer.parseInt(s);
            }else{
                return -Integer.parseInt(s);
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
