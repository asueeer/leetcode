package string.palindrome;

/**
 * @author wangyisu
 */
public class Solution9 {
    public static boolean isPalindrome(int x) {
        if(x<0){
            x*=-1;
        }
        return Solution5.isPalindrome(Integer.toString(x));
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
    }
}
