package hashmap;

import java.util.*;

/**
 * @author wangyisu
 */
public class Solution30 {
    static HashMap<String,Integer> WordMap = new HashMap<>();
    public static List<Integer> findSubstring(String s, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if(WordMap.containsKey(words[i])){
                WordMap.put(words[i],WordMap.get(words[i])+1);
            }else{
                WordMap.put(words[i],1);
            }
        }
        List<Integer> result = new ArrayList<>();
        if(words.length==0){
            return result;
        }
        int len = words.length*words[0].length();
        for (int i = 0; i < s.length()-len+1; i++) {
            if(isSubstring(s.substring(i,i+len),words)){
                result.add(i);
            }
        }
        WordMap.clear();
        return result;
    }

    private static boolean isSubstring(String s, String[] words) {
        HashMap<String,Integer> WordAvl = new HashMap<>(WordMap);
        int i = 0;
        int len = words[0].length();
        while(i<s.length()){
            String substring = s.substring(i, i + len);
            if(WordAvl.containsKey(substring)){
                WordAvl.put(substring,WordAvl.get(substring)-1);
            }
            i+=len;
        }
        for(String key:WordAvl.keySet()){
            if(WordAvl.get(key) != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
        System.out.println(findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","best","good"}));
        System.out.println(findSubstring("",new String[]{}));
    }
}