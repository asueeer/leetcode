package string;

/**
 * @author wangyisu
 */
public class Solution28 {
    public static int strStr(String haystack, String needle) {
        if(haystack.equals(needle)){
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            int start = 0;
            boolean equal = true;
            try{
                for (int j = 0; j < needle.length(); j++) {
                    if(haystack.charAt(i+start)!=needle.charAt(start)){
                        equal = false;
                        break;
                    }else{
                        start++;
                    }
                }
            } catch (Exception e) {
                equal = false;
            }
            if(equal==true){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("",""));
        System.out.println(strStr("aaa","aaaa"));
    }
}
