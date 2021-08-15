package back.tracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static java.util.Collections.sort;
import static string.reformatString.reformat;

/**
 * @author wangyisu
 */
public class Solution39 {
    public static List<List<Integer>> result = new ArrayList<>();
    public static HashSet<String> record = new HashSet<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        result.clear();
        record.clear();
        ArrayList<Integer> lst = new ArrayList<>();
        search(candidates, target, lst);
        return result;
    }

    private static void search(int[] candidates, int target, ArrayList<Integer> lst) {
        for (int i = 0; i < candidates.length; i++) {
            target-=candidates[i];
            lst.add(candidates[i]);
            if(target>0){
                search(candidates, target, lst);
            }else if(target==0){
                ArrayList<Integer> temp = new ArrayList<>(lst);
                sort(temp);
                if(!record.contains(temp.toString())){
                    record.add(temp.toString());
                    result.add(new ArrayList<>(temp));
                }
            } // if target<0, do nothing
            target+=candidates[i];
            lst.remove(lst.size()-1);
        }
    }

    public static void main(String[] args) {
//        System.out.println(reformat("candidates = [2,3,6,7], target = 7,"));
//        System.out.println(reformat("[2,3,5]\n" +
//                "8"));
//        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
//
//        System.out.println(reformat("[10,1,2,7,6,1,5], target = 8"));
        System.out.println(combinationSum(new int[]{2,3,5}, 8));
    }
}
