package back.tracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangyisu
 */
public class Solution17 {
    private static Map<String, String> phone = new HashMap<>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public static List<String> letterCombinations(String digits) {
        List<String> onlyOne_case = new ArrayList<>();
        if(digits.length()==0){
            return onlyOne_case;
        }
        String elements = phone.get(digits.substring(0,1));
        for (int i = 0; i < elements.length(); i++) {
            onlyOne_case.add(elements.substring(i,i+1));
        }
        if(digits.length()==1){
            return onlyOne_case;
        }

        List<String> lst = letterCombinations(digits.substring(1,digits.length()));
        List<String> result = new ArrayList<>(); // 存储新的result
        for (int i = 0; i < lst.size(); i++) {
            for (int j = 0; j < onlyOne_case.size(); j++) {
                result.add(onlyOne_case.get(j)+lst.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("2"));
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("98989898"));
    }
}
