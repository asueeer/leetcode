package hashmap;

import java.util.HashMap;

/**
 * @author wangyisu
 */
public class SolutionJ56 {
    public int[] singleNumbers(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!hashMap.containsKey(nums[i])){
                hashMap.put(nums[i],1);
            }else{
                hashMap.put(nums[i],hashMap.get(nums[i])+1);
            }
        }
        int[] result = new int[2];
        int index = 0;
        for (Integer key:hashMap.keySet()) {
            if(hashMap.get(key)==1){
                result[index] = key;
                index++;
            }
        }
        return result;
    }
}
