package string;

/**
 * @author wangyisu
 */
public class Solution14 {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLength = Math.min(strs[i].length(), minLength);
        }
        String temp = "";
        for (int i = 0; i < minLength; i++) {
            boolean haveCommonChar = true;
            char commomChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(commomChar!=strs[j].charAt(i)){
                    haveCommonChar=false;
                    break;
                }
            }
            if(haveCommonChar==false){
                break;
            }
            temp+=commomChar;
        }
        return temp;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefix(new String[]{}));
    }
}
