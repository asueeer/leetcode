package back.tracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static back.tracking.Solution39.combinationSum;

/**
 * @author wangyisu
 */
public class Solution40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashMap<Integer, Integer> record = new HashMap<>(); // 记录candidates中元素出现的次数
        for (int i = 0; i < candidates.length; i++) {
            int key = candidates[i];
            if(!record.containsKey(key)){
                record.put(key, 1);
            }else{
                record.put(key, record.get(key)+1);
            }
        }
        List<List<Integer>> combination =  combinationSum(candidates, target);
        List<List<Integer>> result =  new ArrayList<>();
        for (int i = 0; i < combination.size(); i++) {
            List<Integer> lst = combination.get(i);
            if(judge(lst, record)){
                result.add(new ArrayList<>(lst));
            }
        }
        return result;
    }

    public static boolean judge(List<Integer> lst, HashMap<Integer, Integer> record) {
        HashMap<Integer, Integer> record_lst = new HashMap<>();
        boolean flag = true;
        for (int i = 0; i < lst.size(); i++) {
            int key = lst.get(i);
            if(!record_lst.containsKey(key)){
                record_lst.put(key, 1);
            }else{
                record_lst.put(key, record_lst.get(key)+1);
            }
        }
        for(Integer key: record_lst.keySet()){
            if(record_lst.get(key)>record.get(key)){
                flag = false;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}
