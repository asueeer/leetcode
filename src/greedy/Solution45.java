package greedy;

/**
 * @author wangyisu
 */
public class Solution45 {
    public int jump(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int step = 0;
        int rightAlmost = 0;
        int oldRightAlmost = 0;
        for (int i = 0; i < nums.length; i++) {
            rightAlmost = i + nums[i];
            if(oldRightAlmost<rightAlmost){
                oldRightAlmost = rightAlmost;
                step++;
            }
            if(oldRightAlmost>=nums.length - 1){
                break;
            }
        }
        return step;
    }
}
