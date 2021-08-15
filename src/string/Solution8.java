package string;

/**
 * @author wangyisu
 */
public class Solution8 {
    public static int myAtoi(String str) {
        if(str.length()==0){
            return 0;
        }
        String s = new String();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)!=' '){
                s = str.substring(i);
                break;
            }
        }
        String temp = "";
        boolean isNegative = false;
        if (s.length()==0) {
            return 0;
        }
        if(s.charAt(0)=='-'){
            isNegative = true;
            for (int i = 1; i < s.length(); i++){
                if(s.charAt(i)<='9' && s.charAt(i)>='0'){
                    temp+=s.charAt(i);
                }else{
                    break;
                }
            }
        }else{
            int start = 0;
            if(s.charAt(0)=='+'){
                start=1;
            }
            for (int i = start; i < s.length(); i++){
                if(s.charAt(i)<='9' && s.charAt(i)>='0'){
                    temp+=s.charAt(i);
                }else{
                    break;
                }
            }
        }
        if (temp.length()==0) {
            return 0;
        }
        try{
            if(isNegative==false){
                return Integer.parseInt(temp);
            }else{
                return -Integer.parseInt(temp);
            }
        } catch (NumberFormatException e) {
            if(isNegative==false){
                return Integer.MAX_VALUE;
            }else{
                return Integer.MIN_VALUE;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi(""));
        System.out.println(myAtoi(" "));
    }
}
