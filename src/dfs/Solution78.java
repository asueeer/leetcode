package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyisu
 */
public class Solution78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        if(nums.length==0){
            result.add(lst);
            return result;
        }

        int first = nums[0];
        int[] sub_nums = new int[nums.length-1];
        for (int i = 0; i < sub_nums.length; i++) {
            sub_nums[i] = nums[i+1];
        }
        List<List<Integer>> sub_result = subsets(sub_nums);
        System.out.println(sub_result);
        for (int i = 0; i < sub_result.size(); i++) {
            List<Integer> sub_lst = sub_result.get(i);
            result.add(new ArrayList<>(sub_lst));
//            if(notIn(first,sub_lst)){
                sub_lst.add(first);
                result.add(sub_lst);
//            }
        }
        return result;
    }

    // 后来发现这一段完全没用
    private static boolean notIn(int first, List<Integer> sub_lst) {
        for (int i = 0; i < sub_lst.size(); i++) {
            if(first==sub_lst.get(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }
}
