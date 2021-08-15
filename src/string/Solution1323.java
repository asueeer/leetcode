package string;

/**
 * @author wangyisu
 */
public class Solution1323 {
    public static int maximum69Number(int num) {
        String s = String.valueOf(num);
        String result = "";
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='6' && flag){
                flag = false;
                result+="9";
            }else{
                result+=s.charAt(i);
            }
        }
        return Integer.parseInt(result);
    }

    public static void main(String[] args) {
        System.out.println(maximum69Number(9669));
    }
}
