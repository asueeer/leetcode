package hashmap;

import java.util.HashMap;

public class Solution1 {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i])){
                return new int[]{hashMap.get(nums[i]),i};
            }else{
                hashMap.put(target-nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        System.out.println(Solution1.twoSum(new int[]{2,7,11,15},9));
    }
}
