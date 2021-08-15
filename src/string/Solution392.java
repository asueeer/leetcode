package string;

/**
 * @author wangyisu
 */
public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int index_t = 0;
        boolean result = true;
        for (int i = 0; i < s.length(); i++) {
//            if(index_t>t.length()){
//                result = false;
//                break;
//            }
            try{
                while (t.charAt(index_t)!=s.charAt(i)){
                    index_t++;
                }
            } catch (Exception e) {
                result = false;
                break;
            }
            index_t++;
            System.out.println("命中");
        }

        return result;
    }

    public static void main(String[] args) {
//        s = "abc", t = "ahbgdc"
        Solution392 solu = new Solution392();
//        System.out.println(solu.isSubsequence("abc", "ahbgdc"));
//        "axc"
//        "ahbgdc"
//        System.out.println(solu.isSubsequence("axc", "ahbgdc"));
        System.out.println(solu.isSubsequence("aaaaaa","bbaaaa"));
    }
}
