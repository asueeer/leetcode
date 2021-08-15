package string;

/**
 * @author wangyisu
 */
public class KMP {
    public static boolean match(String s, String p){
        if(p.length()==0){
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==p.charAt(0)){
                if(match(s.substring(i+1),p.substring(1))){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(match("abcdef","abcabab"));
    }
}
