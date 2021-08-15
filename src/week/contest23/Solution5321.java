package week.contest23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author wangyisu
 */
public class Solution5321 {
    public static boolean canConstruct__(String s, int k) {
        String[] strings = permutation(s);
        for (int i = 0; i < strings.length; i++) {
            if(canConstruct_(strings[i],k)){
                return true;
            }
        }
        return false;
    }

    public static String[] permutation(String s) {
        int len = s.length();
        if (len == 0) {
            return new String[0];
        }

        // 转换成字符数组是常见的做法
        char[] charArr = s.toCharArray();
        // 排序是为了去重方便
        Arrays.sort(charArr);

        // 由于操作的都是字符，使用 StringBuilder
        StringBuilder path = new StringBuilder();
        boolean[] used = new boolean[len];

        // 为了方便收集结果，使用动态数组
        List<String> res = new ArrayList<>();
        dfs(charArr, len, 0, used, path, res);

        // 记得转成字符串数组
        return res.toArray(new String[0]);
    }

    /**
     * @param charArr 字符数组
     * @param len     字符数组的长度
     * @param depth   当前递归深度
     * @param used    当前字符是否使用
     * @param path    从根结点到叶子结点的路径
     * @param res     保存结果集的变量
     */
    private static void dfs(char[] charArr,
                            int len,
                            int depth,
                            boolean[] used,
                            StringBuilder path,
                            List<String> res) {
        if (depth == len) {
            // path.toString() 恰好生成了新的字符对象
            res.add(path.toString());
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                if (i > 0 && charArr[i] == charArr[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                path.append(charArr[i]);

                dfs(charArr, len, depth + 1, used, path, res);

                // 递归完成以后，需要撤销选择，递归方法执行之前做了什么，递归方法执行以后就需要做相应的逆向操作
                path.deleteCharAt(path.length() - 1);
                used[i] = false;
            }
        }
    }

    public static boolean canConstruct_(String s, int k) {
        if(k==1){
            if(isPalindrome(s)){
                return true;
            }else{
                return false;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if(isPalindrome(s.substring(0,i+1))){
                if(canConstruct_(s.substring(i+1),k-1)){
                    return true;
                }
            }
        }
        return false;
    }

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

    public static boolean canConstruct(String s, int k) {
        if(k>s.length()){
            return false;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!hashMap.containsKey(ch)){
                hashMap.put(ch, 1);
            }else{
                hashMap.put(ch, hashMap.get(ch)+1);
            }
        }
        int num = 0;
        for(Character ch:hashMap.keySet()){
            if(hashMap.get(ch)%2!=0){
                num++;
            }
        }
        if(num>k){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("annabelle", 2));

    }
}
