package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static java.util.Collections.sort;

/**
 * @author wangyisu
 * threeSum、FourSum这几道题写的相当丑，扩展性不强
 */
public class Solution18 {
    static HashSet<List<Integer>> set = new HashSet<>();
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<Integer> computed = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(!computed.contains(nums[i])){
                threeSum(nums, i, target, result);
            }
        }
        set.clear();
        return result;
    }

    public static void threeSum(int[] nums, int index, int target, List<List<Integer>> result) {
        for (int j = 0; j < nums.length; j++) {
            if(j!=index){
                twoSum(nums, index, j,target, result);
            }
        }
    }

    public static void twoSum(int[] nums, int index,int j_index, int target, List<List<Integer>> result) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int k = 0; k < nums.length; k++) {
            if(k!=index && k!=j_index){
                if(map.containsKey(nums[k])){
                    List<Integer> lst = new ArrayList<>();
                    lst.add(nums[index]);
                    lst.add(nums[j_index]);
                    lst.add(nums[k]);
                    lst.add(nums[map.get(nums[k])]);
                    sort(lst);
                    if(!set.contains(lst)){
                        result.add(lst);
                        set.add(lst);
                    }
                }else{
                    map.put(target-nums[index]-nums[j_index]-nums[k],k);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1,0,-1,0,-2,2},0));
    }
}
