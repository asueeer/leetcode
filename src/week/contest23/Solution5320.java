package week.contest23;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author wangyisu
 */
public class Solution5320 {
    public static int countLargestGroup(int n) {
        HashMap<Integer,Integer> set = new HashMap<>();
        int max = 0;
        for (int i = 1; i < n+1; i++) {
            String s = String.valueOf(i);
            int sum_byDigit = 0;
            for (int j = 0; j < s.length(); j++) {
                sum_byDigit+=Integer.parseInt(s.substring(j,j+1));
            }
            if(set.containsKey(sum_byDigit)){
                set.put(sum_byDigit,set.get(sum_byDigit)+1);
            }else{
                set.put(sum_byDigit,1);
            }
            if(set.get(sum_byDigit)>max){
                max = set.get(sum_byDigit);
            }
        }
        int num = 0;
        for (Integer key:set.keySet()) {
            if(set.get(key)==max){
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
//        System.out.println(countLargestGroup(13));
        System.out.println(countLargestGroup(2));
    }
}
