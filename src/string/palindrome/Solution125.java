package string.palindrome;

/**
 * @author wangyisu
 */
public class Solution125 {
    public static boolean isPalindrome(String s) {
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)<='z' && s.charAt(i)>='a'){
                temp+=s.charAt(i);
            }
            if(s.charAt(i)<='Z' && s.charAt(i)>='A'){
                temp+=s.charAt(i);
            }
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                temp+=s.charAt(i);
            }
        }
        s = temp;
        System.out.println(s);
        int lo = 0;
        int hi = s.length()-1;
        while(lo<=hi){
            if(s.charAt(lo)!=s.charAt(hi)){
                if(s.charAt(lo)>='0' && s.charAt(lo)<='9'){
                    return false;
                }
                if(s.charAt(hi)>='0' && s.charAt(hi)<='9'){
                    return false;
                }
                if((s.charAt(lo)+32)!=s.charAt(hi) && (s.charAt(lo)-32)!=s.charAt(hi)){
                    return false;
                }
            }
            lo++;
            hi--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
        System.out.println('0'-'P');
    }
}
