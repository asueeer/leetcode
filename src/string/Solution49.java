package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wangyisu
 */
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101};
        HashMap<Integer, ArrayList<String>> hashMap = new HashMap<>();
        for(String str:strs){
            int value = 1;
            for (int i = 0; i < str.length(); i++) {
                value*=primes[str.charAt(i)-'a'];
            }
            if(hashMap.containsKey(value)){
                hashMap.get(value).add(str);
            }else{
                ArrayList<String> lst = new ArrayList<>();
                lst.add(str);
                hashMap.put(value, lst);
            }
        }
        ArrayList<List<String>> result = new ArrayList<>();
        for(int key:hashMap.keySet()){
            result.add(hashMap.get(key));
        }
        return result;
    }
}
