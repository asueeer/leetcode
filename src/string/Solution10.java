package string;

/**
 * @author wangyisu
 */
public class Solution10 {
    public static boolean isMatch(String s, String p) {
        if(s.length()==0 && p.length()==0){
            return true;
        }
        boolean secondCharIsStar = SecondCharIsStar(p);
        boolean firstCharMatch = FirstCharMatch(s,p);
        if(secondCharIsStar) {
            // 削减规模 p为'a*a*'时，变为p为'a*'
            if (p.length()>=4 &&p.substring(0, 2).equals(p.substring(2, 4))) {
                return isMatch(s, p.substring(2));
            }
            // 进行判断
            if(firstCharMatch){
                // s='aa'， p='a*b'时，首字符相同，有两种选择，1：s去掉首字符，p保持不变；2：s保持不变，p去掉*a
                return isMatch(s.substring(1),p) || isMatch(s,p.substring(2));
            }else{
                // 首字符不同，s='bb',p='a*b'时，只能s保持不变，p去掉*a
                return isMatch(s,p.substring(2));
            }
        }

        if(firstCharMatch){
            return isMatch(s.substring(1),p.substring(1));
        }
        return false;
    }

    private static boolean FirstCharMatch(String s, String p) { // p[0]==s[0] or p[0]=='.'
        if(s.length()>=1 && p.length()>=1){
            return (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.');
        }else{
            return false;
        }
    }

    private static boolean SecondCharIsStar(String p) { // p[1]=='*'
        if(p.length()>=2 && p.charAt(1)=='*'){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isMatch("a","aa"));
        System.out.println(isMatch("aa","a"));
        System.out.println(isMatch("aa","a*"));
        System.out.println(isMatch("mississippi","mis*is*ip*."));
        System.out.println(isMatch("ab",".*c"));
        System.out.println(isMatch("ab",".*"));
        System.out.println(isMatch("aaa","a*a"));
        System.out.println(isMatch("aab","c*a*b"));
        System.out.println(isMatch("aaa","ab*a*c*a"));
        System.out.println(isMatch("aaaaaaaaaaaaab","a*a*b"));
        System.out.println(isMatch("","c*c*"));
        System.out.println(isMatch("aabcbcbcaccbcaabc",".*a*aa*.*b*.c*.*a*"));
    }
}
