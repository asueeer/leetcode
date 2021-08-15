package dp;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author wangyisu
 */
public class Solution55 {
    // Todo
    public static boolean canJumpToEnd = false;
    HashSet<Integer> visited;
    public boolean canJump(int[] nums) {
        canJumpToEnd = false;
        int start = 0;
        visited = new HashSet<>();
        jump(start, nums);
        return canJumpToEnd;
    }

    private void jump(int start, int[] nums) {
        if(visited.contains(start)){
            return;
        }
        visited.add(start);
        System.out.println(start);
        if(start==nums.length - 1){
            canJumpToEnd = true;
        }
        if(nums[start]==0 || canJumpToEnd){
            System.out.println("!!!");
            return;
        }
        for (int i = nums[start]; i >=1 ; i--) {
            if(start+i >= nums.length){
                System.out.println("无法跳跃");
                continue;
            }
            jump(start+i, nums);
        }
    }

    public static void main(String[] args) {
        Solution55 solu = new Solution55();
//        System.out.println(solu.canJump(new int[]{2,3,1,1,4}));
        System.out.println(solu.canJump(new int[]{3,2,1,0,4}));
    }
}
